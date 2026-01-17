package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jackson2.SecurityJackson2Modules;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper securityObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModules(
            SecurityJackson2Modules.getModules(
                this.getClass().getClassLoader()
            )
        );
        return mapper;
    }
}

