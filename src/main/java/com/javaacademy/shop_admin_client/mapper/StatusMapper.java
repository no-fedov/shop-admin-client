package com.javaacademy.shop_admin_client.mapper;

import com.javaacademy.shop_admin_client.dto.StatusDto;
import com.javaacademy.shop_admin_client.dto.StatusDtoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StatusMapper {

    @Mapping(target = "status", expression = "java(statusDto.getShopStatus().name().toLowerCase())")
    StatusDtoResponse convertToResponseDto(StatusDto statusDto);
}
