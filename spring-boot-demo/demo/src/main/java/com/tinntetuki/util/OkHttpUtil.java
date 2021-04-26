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
package com.tinntetuki.util;

import com.tinntetuki.constants.Constants;
import okhttp3.*;
import org.apache.http.client.utils.DateUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.CookieManager;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tinntetuki
 */
public class OkHttpUtil {

    static OkHttpClient client = new OkHttpClient();
    static Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("", 9999));

    public static String run(String url, String ... params) throws IOException {
        url = getString(url, params);
        System.out.println(url);

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

    private static String getString(String url, String[] params) throws UnsupportedEncodingException {
        //权限处理
        //AccessKeyId=e2xxxxxx-99xxxxxx-84xxxxxx-7xxxx&SignatureMethod=HmacSHA256&SignatureVersion=2&Timestamp=2017-05-11T15%3A19%3A30

        /*String finalUrl = url;
        String api = "";

        boolean signature = Constants.HUOBI_API_LIST.stream().anyMatch(c -> finalUrl.contains(c));
        if(signature){
            String signatureMethod = "HmacSHA256";
            String signatureVersion = "2";
            String timestamp= DateUtils.formatDate(new Date(System.currentTimeMillis()), "YYYY-MM-dd hh:mm:ss");
            timestamp = timestamp.replace(" ", "T");

             api = Constants.ACCESSKEYID + "=" + Constants.ACCESSKEYID_HUOBI + "&"
                    + Constants.SIGNATUREMETHOD + "=" + signatureMethod + "&"
                    + Constants.SIGNATUREVERSION + "=" + signatureVersion + "&"
                    + Constants.TIMESTAMP + "=" + URLEncoder.encode(timestamp, "UTF-8").toUpperCase(Locale.ROOT);

            return url;
        }

        AtomicInteger i = new AtomicInteger();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(params).forEach(c -> {
            sb.append(c);
            if (i.get() % 2 == 0) {
                sb.append("=");
            }
            i.getAndIncrement();
        });


        url += sb.toString();*/
        return url;
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

    public static void main(String[] args) {
        OkHttpUtil util = new OkHttpUtil();
        try {
            System.out.println(run(Constants.URL_PREFIX_HUOBI + Constants.HUOBI_URL_POST_V2_CURRENCIES));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
