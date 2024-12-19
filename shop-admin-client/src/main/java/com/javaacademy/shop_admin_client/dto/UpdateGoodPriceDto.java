package com.javaacademy.shop_admin_client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Обновление цены товара")
public class UpdateGoodPriceDto {
    @Schema(description = "Имя товара")
    private String name;
    @Schema(description = "Новая цена")
    @JsonProperty("new_price")
    private BigDecimal newPrice;
}
