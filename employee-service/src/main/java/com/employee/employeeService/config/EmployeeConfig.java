package com.employee.employeeService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeConfig {

    @Bean
    public RestTemplate getRestTemplate   (){
        return new RestTemplate();
    }

    @Bean
    public WebClient getWebClient(){
        return WebClient.builder().build();
    }
}
