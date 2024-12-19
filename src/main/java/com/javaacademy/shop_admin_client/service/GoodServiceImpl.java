package com.javaacademy.shop_admin_client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_admin_client.config.GoodPriceURL;
import com.javaacademy.shop_admin_client.dto.UpdateGoodPriceDto;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {

    private final OkHttpClient client;
    private final ObjectMapper mapperJSON;
    private final GoodPriceURL goodPriceURL;

    @Override
    @SneakyThrows
    public void updateGoodPrice(UpdateGoodPriceDto dto) {
        RequestBody requestBody = RequestBody.create(mapperJSON.writeValueAsString(dto),
                MediaType.parse("application/json"));
        for (String url : goodPriceURL.getUrl()) {
            updateGoodPriceInServer(url, requestBody);
        }
    }

    private void updateGoodPriceInServer(String url,  RequestBody requestBody) throws IOException {
        Request request = new Request.Builder().url(url).patch(requestBody).build();
        @Cleanup
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new RuntimeException("Ошибка на сервере магазина");
        }
    }
}
