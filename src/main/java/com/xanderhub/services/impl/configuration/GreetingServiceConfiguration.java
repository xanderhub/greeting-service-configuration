package com.xanderhub.services.impl.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GreetingServiceConfiguration {

    @Bean
    @ConfigurationProperties("app.greeting.language")
    Map<String, String> translatedGreetings() {
        return new HashMap<>();
    }
}
