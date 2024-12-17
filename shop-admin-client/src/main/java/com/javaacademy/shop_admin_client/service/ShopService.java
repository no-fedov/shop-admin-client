package com.javaacademy.shop_admin_client.service;

import com.javaacademy.shop_admin_client.dto.StatusDtoResponse;

import java.util.List;

public interface ShopService {

    List<StatusDtoResponse> getStatusShops();
}
