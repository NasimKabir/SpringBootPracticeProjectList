package com.nasim.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.nasim.security.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
	private String secretKey = "SpringBootTutorial";
	private Long expireHour = Long.valueOf("5");

	public String generateToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		Date now = new Date();
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(now)
				.setExpiration(DateUtils.getExpirationTime(expireHour))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
		
	}
	
	 public Long getUserIdFromJwtToken(String token){
	        Claims claims = Jwts.parser()
	                .setSigningKey(secretKey).parseClaimsJws(token).getBody();
	        return Long.valueOf(claims.getSubject());
	    }

	 public String getUserNameFromJwtToken(String token) {
			return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
		}

		public boolean validateJwtToken(String authToken) {
			try {
				Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
				return true;
			} catch (SignatureException e) {
				logger.error("Invalid JWT signature: {}", e.getMessage());
			} catch (MalformedJwtException e) {
				logger.error("Invalid JWT token: {}", e.getMessage());
			} catch (ExpiredJwtException e) {
				logger.error("JWT token is expired: {}", e.getMessage());
			} catch (UnsupportedJwtException e) {
				logger.error("JWT token is unsupported: {}", e.getMessage());
			} catch (IllegalArgumentException e) {
				logger.error("JWT claims string is empty: {}", e.getMessage());
			}

			return false;
		}

}
