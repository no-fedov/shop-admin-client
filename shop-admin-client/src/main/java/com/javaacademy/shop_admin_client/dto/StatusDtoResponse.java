package com.javaacademy.shop_admin_client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDtoResponse {
        private String name;
        private String status;
        @JsonProperty("time_open")
        private String timeOpen;
        @JsonProperty("time_close")
        private String timeClose;
}
