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

import com.fasterxml.jackson.core.type.TypeReference;
import com.tinntetuki.constants.Constants;
import com.tinntetuki.model.binace.Tickers;

import java.io.IOException;
import java.util.List;

import static com.tinntetuki.util.OkHttpUtil.run;

/**
 * @author tinntetuki
 */
public class BinaceUtil {

    public static List<Tickers> getTickers() throws IOException {
        String value = run(Constants.URL_PREFIX_BINACE + Constants.BINACE_URL_GET_TICKER_PRICE);
        List<Tickers> tickers = ObjectMapperUtil.objectMapper.readValue(value, new TypeReference<List<Tickers>>() { });
        tickers.forEach(c -> {
            //System.out.println(c.toString());
            if("ETHUSDT".equals(c.getSymbol())){
                System.out.println(c.toString());
            }
        });

        return tickers;
    }
}
