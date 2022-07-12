package com.dh.apiDentalClinic.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "jwtAuth",
        description = "You need a JWT obtained from user, you can obtain this in auth method login",
        bearerFormat = "JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP
)
public class SwagguerConfig {

    @Bean
    public OpenAPI customApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Dentist Clinic Api Digital House")
                        .description("This document contains the documentation for using the dentist clinic API")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Elkin Silva Manrique")
                                .email("elkinsilvamanrique@gmail.com")
                                .url("https://github.com/Elkinssm")
                                .url("https://www.linkedin.com/in/elkinssm/")
                        )
                );
    }
}
