package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // CSRF無効化（問い合わせフォームの簡易版ならOK）
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // 全てのURLを認証不要
            );
        return http.build();
    }
}


