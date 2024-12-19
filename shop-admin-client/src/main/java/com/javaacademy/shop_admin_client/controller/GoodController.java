package com.javaacademy.shop_admin_client.controller;

import com.javaacademy.shop_admin_client.dto.UpdateGoodPriceDto;
import com.javaacademy.shop_admin_client.service.GoodService;
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
public class GoodController {

    private final GoodService service;

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchGoodPrice(@RequestBody UpdateGoodPriceDto dto) {
        service.updateGoodPrice(dto);
    }
}
