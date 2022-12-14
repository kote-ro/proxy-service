package com.opensource.proxyservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFluxConfiguration {
    @Bean
    WebClient getWebClient(){
        return WebClient.create();
    }
}
