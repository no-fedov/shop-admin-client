package com.javaacademy.shop_admin_client.controller;

import com.javaacademy.shop_admin_client.dto.StatusDtoResponse;
import com.javaacademy.shop_admin_client.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopStatusController {

    private final ShopService service;

    @GetMapping("/status")
    public List<StatusDtoResponse> getStatusShops() {
        return service.getStatusShops();
    }
}
