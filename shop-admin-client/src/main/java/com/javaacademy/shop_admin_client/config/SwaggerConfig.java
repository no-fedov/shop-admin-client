package com.javaacademy.shop_admin_client.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        Info info = new Info()
                .title("Это api сети магазинов")
                .description("Это приложение для управляющего сетью магазинов! " +
                        "Управляющий может узнать статус магазина и поменять цену товара");
        return new OpenAPI()
                .info(info);
    }
}
