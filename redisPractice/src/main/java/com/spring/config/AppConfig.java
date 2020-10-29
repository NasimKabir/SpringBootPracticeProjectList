package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.spring.model.Student;

@Configuration
public class AppConfig {
	@Bean
	public RedisConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Student> redisTemplate() {
		RedisTemplate<String, Student> template = new RedisTemplate<String, Student>();
		template.setConnectionFactory(connectionFactory());
		return template;
	}
}
