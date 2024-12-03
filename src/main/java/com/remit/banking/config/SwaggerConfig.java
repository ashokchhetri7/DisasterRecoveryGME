package com.remit.banking.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(info = @Info(
        title = "GME Remit Recovery API",
        version = "1.0.8",
        description = "Secure Banking API for Disastery Recovery Scenario"
))
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                                .bearerFormat("JWT")
                        )
                );
    }
}