package com.javaacademy.shop_admin_client.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "app.shop.good.update-price")
public class GoodPriceURL {

    private List<String> url;
}
