package com.nasim.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nasim.jwt.JwtAuthenticationFilter;
import com.nasim.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private  UserDetailsServiceImpl customUserDetailsService;
	@Autowired
	private  PasswordEncoder passwordEncoder;
	@Autowired
    private  MyAuthenticationEntryPoint myAuthenticationEntryPoint;
	@Autowired
    private  JwtAuthenticationFilter authenticationFilter;
    
    
	
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	
	

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 http.cors()
         .and()
         .csrf()
         .disable()
         .exceptionHandling()
         .authenticationEntryPoint(myAuthenticationEntryPoint)
         .and()
         .sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .authorizeRequests()
         .antMatchers("/","/login").permitAll()
         .antMatchers("/role","/signup").permitAll()
         .anyRequest()
         .authenticated();
		 
		 http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
		 
	       
	    }

	 
}
