package com.javaacademy.shop_admin_client.controller;

import com.javaacademy.shop_admin_client.dto.StatusDtoResponse;
import com.javaacademy.shop_admin_client.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
@Tag(name = "Shop's status controller", description = "Контроллер для управления статусами сети магазинов")
public class ShopStatusController {

    private final ShopService service;

    @GetMapping("/status")
    @Operation(summary = "Получение статусов магазинов",
            description = "Отправляет запросы на все серверы магазинов для получения статуса")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = StatusDtoResponse.class))
                    )
            )
    })
    public List<StatusDtoResponse> getStatusShops() {
        return service.getStatusShops();
    }
}
