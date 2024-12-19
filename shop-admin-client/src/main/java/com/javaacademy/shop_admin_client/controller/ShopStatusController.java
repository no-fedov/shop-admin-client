package com.javaacademy.shop_admin_client.controller;

import com.javaacademy.shop_admin_client.dto.StatusDtoResponse;
import com.javaacademy.shop_admin_client.service.ShopService;
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
    public List<StatusDtoResponse> getStatusShops() {
        return service.getStatusShops();
    }
}
