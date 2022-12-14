package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/first-service/**")// path를 확인하고
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                                .addResponseHeader("first-response", "first-response-header"))  // filterfmf 적용해서
                        .uri("http://localhost:8081"))     // uri로 이동시켜 주는거다.
                .route(r -> r.path("/second-service/**")// path를 확인하고
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addResponseHeader("second-response", "second-response-header"))  // filterfmf 적용해서
                        .uri("http://localhost:8082"))     // uri로 이동시켜 주는거다.
                .build();
    }
}
