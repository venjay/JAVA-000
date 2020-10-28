package com.venjay.week02.server.request;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author :liuwenjie
 * @description : 请求
 * @date : 2020/10/28 21:12
 * @since 1.0.0
 **/
public class httpClient {
    private static Logger logger = LoggerFactory.getLogger(httpClient.class);
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8808").build();
        try {
            Response response = client.newCall(request).execute();
            logger.info(response.body().toString());
        } catch (IOException e) {
            logger.error(" request", e);
        }
    }
}
