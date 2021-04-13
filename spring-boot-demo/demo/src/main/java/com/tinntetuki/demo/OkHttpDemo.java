/*
 * Copyright 1999-2018 tinntetuki Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tinntetuki.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinntetuki.constants.Constants;
import com.tinntetuki.mapper.SymbolMapper;
import com.tinntetuki.model.huobi.Currencies;
import com.tinntetuki.model.huobi.Symbol;
import com.tinntetuki.model.huobi.Tickers;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;

/**
 * @author tinntetuki
 */
public class OkHttpDemo {
    @Autowired
    SymbolMapper symbolMapper;

    static ObjectMapper objectMapper = new ObjectMapper();
    static OkHttpClient client = new OkHttpClient();
    static Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("3.142.82.250", 9999));
    static{
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    };

    public static void main(String[] args) throws Exception{
        ///System.out.println(run("https://api.huobi.pro/v1/settings/currencys?language=en-US"));
        //System.out.println(run("https://www.baidu.com/"));
        //System.out.println(run("https://api.huobi.pro/market/history/kline?symbol=btcusdt&period=1min&size=1"));
        //System.out.println(run("https://api.huobi.pro/market/history/kline?symbol=ethusdt&period=1min&size=1"));
        //System.out.println();
        //System.out.println( run("https://api.huobi.pro/market/tickers"));
        //System.out.println(value);
        //System.out.println(map.get("data"));
        //List<Symbol> symbolList = objectMapper.readValue(map.get("data").toString(), new TypeReference<List<Symbol>>(){});
    }

    static void getTickers() throws IOException{
        String value = run(Constants.URL_PREFIX_HUOBI + Constants.HUOBI_URL_GET_MARKET_TICKERS);
        Tickers tickers = objectMapper.readValue(value, Tickers.class);
        tickers.getData().forEach(c -> {
            System.out.println(c.toString());
        });
    }

    static void getCurrencies() throws IOException{
        String value = run(Constants.URL_PREFIX_HUOBI + Constants.HUOBI_URL_POST_V2_CURRENCIES);
        Currencies currencies = objectMapper.readValue(value, Currencies.class);
        currencies.getData().forEach(c -> {
            c.getChains().forEach(chain ->{
                System.out.println(chain.toString());
            });
        });
    }

    static void getSymbol() throws IOException {
        String value = run("https://api.huobi.pro/v1/common/symbols");
        Symbol symbol = objectMapper.readValue(value, Symbol.class);
        symbol.getData().forEach(c -> {
            System.out.println(c.getSymbol().toString());
        });
    }

    static String run(String url) throws IOException {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(1, TimeUnit.MINUTES);
        builder.proxy(proxy);
        CookieManager cookieManager = new CookieManager();
        OkHttpClient client = builder
                //.cookieJar(new JavaNetCookieJar(cookieManager))
                .build();
        Request request = new Request.Builder()
                .url(url)
                .build()
                ;

        try (Response response = client.newCall(request).execute()) {

            return response.body().string().replace("-", "");

        }
    }

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");


    static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
