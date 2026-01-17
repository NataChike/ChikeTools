package com.example.demo.config;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RedisStateAuthenticationEntryPoint
		implements AuthenticationEntryPoint {

	private final StringRedisTemplate redisTemplate;

	public RedisStateAuthenticationEntryPoint(
			StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void commence(
			HttpServletRequest request,
			HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		String state = UUID.randomUUID().toString();

		String redirectUrl = request.getRequestURL().toString();
		if (request.getQueryString() != null) {
			redirectUrl += "?" + request.getQueryString();
		}

		redisTemplate.opsForValue().set(
				"login:state:" + state,
				redirectUrl,
				Duration.ofMinutes(5));

		response.sendRedirect(
				"https://chiketools.com/auth/login?state=" + state);
	}
}
