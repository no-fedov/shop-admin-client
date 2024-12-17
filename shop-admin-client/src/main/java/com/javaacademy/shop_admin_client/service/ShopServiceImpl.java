package com.javaacademy.shop_admin_client.service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_admin_client.config.StatusShopURL;
import com.javaacademy.shop_admin_client.dto.StatusDto;
import com.javaacademy.shop_admin_client.dto.StatusDtoResponse;
import com.javaacademy.shop_admin_client.mapper.StatusMapper;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final OkHttpClient client;
    private final ObjectMapper mapperJSON;
    private final StatusMapper statusMapper;
    private final StatusShopURL statusShopURL;

    @Override
    public List<StatusDtoResponse> getStatusShops() {
        List<StatusDtoResponse> statusDtos = new ArrayList<>();
        for (String url : statusShopURL.getUrl()) {
            try {
                statusDtos.add(getStatusDtoFromServer(url));
            } catch (JacksonException e) {
                log.warn("Ошибка парсинга ответа сервера на GET запрос по URL: {}. Ошибка: {}", url, e.getMessage());
            } catch (IOException e) {
                log.warn("Ошибка выполнения запроса GET по URL: {}. Ошибка: {}", url, e.getMessage());
            }
        }
        return statusDtos;
    }

    private StatusDtoResponse getStatusDtoFromServer(String url) throws JacksonException, IOException {
        Request request = new Request.Builder().get().url(url).build();
        @Cleanup
        Response response = client.newCall(request).execute();
        String bodyResponse = response.body().string();
        StatusDto statusDto = mapperJSON.readValue(bodyResponse, StatusDto.class);
        return statusMapper.convertToResponseDto(statusDto);
    }
}
