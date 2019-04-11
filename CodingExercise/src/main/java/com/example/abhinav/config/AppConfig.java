package com.example.abhinav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.abhinav.service.InvetmentServiceImpl;


@Configuration
public class AppConfig {
    @Bean
    public InvetmentServiceImpl transferService() {
        return new InvetmentServiceImpl();
    }
}