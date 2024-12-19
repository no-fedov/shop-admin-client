package com.javaacademy.shop_admin_client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Представление статуса магазина для админа")
public class StatusDtoResponse {
        @Schema(description = "Имя магазина")
        private String name;
        @Schema(description = "Статус магазина")
        private String status;
        @Schema(description = "Время открытия")
        @JsonProperty("time_open")
        private String timeOpen;
        @Schema(description = "Время закрытия")
        @JsonProperty("time_close")
        private String timeClose;
}
