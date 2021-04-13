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
import com.tinntetuki.model.huobi.AccountDepositAddress;
import com.tinntetuki.model.huobi.Currencies;
import com.tinntetuki.model.huobi.Symbol;
import com.tinntetuki.model.huobi.Tickers;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Locale;

import static com.tinntetuki.util.OkHttpUtil.run;

/**
 *
 * @author tinntetuki
 */
@Slf4j
public class HuoBiUtil {

    public static AccountDepositAddress getAccountDepositAddress(String symbol) throws  IOException{
        String value = run(Constants.URL_PREFIX_HUOBI + Constants.HUOBI_URL_GET_ACCOUNT_DEPOSIT_ADDRESS, "currency", symbol);
        AccountDepositAddress accountDepositAddress = ObjectMapperUtil.objectMapper.readValue(value, AccountDepositAddress.class);
        accountDepositAddress.getData().forEach(c -> {
            System.out.println(c.toString());
        });
        return accountDepositAddress;
    }


    public static Tickers getTickers() throws IOException{
        String value = run(Constants.URL_PREFIX_HUOBI + Constants.HUOBI_URL_GET_MARKET_TICKERS);
        Tickers tickers = ObjectMapperUtil.objectMapper.readValue(value, Tickers.class);
        tickers.getData().forEach(c -> {
            if("ethhusd".equals(c.getSymbol())){
                System.out.println(c.toString());
            }
        });
        return tickers;
    }

    public static Currencies  getCurrencies() throws IOException {
        String value = run(Constants.URL_PREFIX_HUOBI + Constants.HUOBI_URL_POST_V2_CURRENCIES);
        Currencies currencies = ObjectMapperUtil.objectMapper.readValue(value, Currencies.class);
        log.info("currencies size : {}", currencies.getData().size());
        currencies.getData().forEach(c -> {
            c.getChains().forEach(chain ->{
                if(chain.getChain().toLowerCase(Locale.ROOT).contains("ctxc")){
                    System.out.println(chain.toString());
                }
            });
        });
        return currencies;
    }

    public static Symbol getSymbol() throws IOException {
        String value = run("https://api.huobi.pro/v1/common/symbols");
        Symbol symbol = ObjectMapperUtil.objectMapper.readValue(value, Symbol.class);
        symbol.getData().forEach(c -> {
            //System.out.println(c.getSymbol().toString());
        });
        log.info("symbol size : {}", symbol.getData().size());
        return symbol;
    }
}
