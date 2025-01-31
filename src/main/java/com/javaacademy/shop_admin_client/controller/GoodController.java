package com.javaacademy.shop_admin_client.controller;

import com.javaacademy.shop_admin_client.dto.StatusDtoResponse;
import com.javaacademy.shop_admin_client.dto.UpdateGoodPriceDto;
import com.javaacademy.shop_admin_client.service.GoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/good")
@RequiredArgsConstructor
@Tag(name = "Good controller", description = "Контроллер для работы c товарами")
public class GoodController {

    private final GoodService service;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Обновление цены товара",
            description = "Отправляет запросы на все серверы магазинов для обновления цены товара")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204"),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере магазина")
    })
    public void patchGoodPrice(@RequestBody UpdateGoodPriceDto dto) {
        service.updateGoodPrice(dto);
    }
}
