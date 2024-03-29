package com.challenge.configs;

import com.challenge.models.Cliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

@Configuration
public class Swagger {

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.challenge"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(Cliente.class)
                .globalOperationParameters(Arrays.asList(
                    new ParameterBuilder()
                        .name("Authorization")
                        .description("Bearer Token")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(false)
                        .build()));
    }
}
