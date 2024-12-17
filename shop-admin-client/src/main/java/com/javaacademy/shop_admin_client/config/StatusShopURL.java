package com.javaacademy.shop_admin_client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "app.shop.status")
public class StatusShopURL {

    private List<String> url;
}
