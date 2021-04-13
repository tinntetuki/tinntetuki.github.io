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
package com.tinntetuki.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tinntetuki
 */
public class Constants {
    public static final List<String> HUOBI_API_LIST = new ArrayList<>() ;

    static{
        HUOBI_API_LIST.add(Constants.HUOBI_URL_GET_ACCOUNT_DEPOSIT_ADDRESS);
    }


    public static final String ACCESSKEYID= "AccessKeyId";
    public static final String SIGNATUREMETHOD = "SignatureMethod";
    public static final String SIGNATUREVERSION = "SignatureVersion";
    public static final String TIMESTAMP= "Timestamp";
    public static final String URL_PREFIX_HUOBI= "https://api.huobi.pro";

    /**
     * 此节点用于查询各币种及其所在区块链的静态参考信息（公共数据）
     */
    public static final String HUOBI_URL_POST_V2_CURRENCIES = "/v2/reference/currencies";

    /**
     * 所有交易对的最新 Tickers
     */
    public static final String HUOBI_URL_GET_MARKET_TICKERS = "/market/tickers";

    /**
     * 充币地址查询
     */
    public static final String HUOBI_URL_GET_ACCOUNT_DEPOSIT_ADDRESS ="/v2/account/deposit/address";

    /**
     * BINACE API 地址
     */
    public static final String URL_PREFIX_BINACE = "https://api.binance.com";

    /**
     * 获取交易对最新价格
     */
    public static final String BINACE_URL_GET_TICKER_PRICE = "/api/v3/ticker/price";

}
