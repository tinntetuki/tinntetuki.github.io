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
package com.tinntetuki.model.huobi;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tinntetuki
 */
@NoArgsConstructor
@Data
@Ignore
public class Symbol {

    /**
     * status : ok
     * data : [{"basecurrency":"jst","quotecurrency":"eth","priceprecision":8,"amountprecision":2,"symbolpartition":"innovation","symbol":"jsteth","state":"online","valueprecision":8,"minorderamt":1,"maxorderamt":17100000,"minordervalue":0.01,"limitorderminorderamt":1,"limitordermaxorderamt":17100000,"sellmarketminorderamt":1,"sellmarketmaxorderamt":1710000,"buymarketmaxordervalue":365,"apitrading":"enabled"},{"basecurrency":"neo","quotecurrency":"husd","priceprecision":4,"amountprecision":4,"symbolpartition":"innovation","symbol":"neohusd","state":"online","valueprecision":8,"minorderamt":0.001,"maxorderamt":60000,"minordervalue":5,"limitorderminorderamt":0.001,"limitordermaxorderamt":60000,"sellmarketminorderamt":0.001,"sellmarketmaxorderamt":6000,"buymarketmaxordervalue":100000,"apitrading":"enabled"}]
     */


    private String status;
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    @Builder
    public static class DataDTO {
        /**
         * basecurrency : jst
         * quotecurrency : eth
         * priceprecision : 8
         * amountprecision : 2
         * symbolpartition : innovation
         * symbol : jsteth
         * state : online
         * valueprecision : 8
         * minorderamt : 1
         * maxorderamt : 17100000
         * minordervalue : 0.01
         * limitorderminorderamt : 1
         * limitordermaxorderamt : 17100000
         * sellmarketminorderamt : 1
         * sellmarketmaxorderamt : 1710000
         * buymarketmaxordervalue : 365
         * apitrading : enabled
         */

        /**
         * 字段名称	是否必须	数据类型	描述
         * base-currency	true	string	交易对中的基础币种
         * quote-currency	true	string	交易对中的报价币种
         * price-precision	true	integer	交易对报价的精度（小数点后位数）
         * amount-precision	true	integer	交易对基础币种计数精度（小数点后位数）
         * symbol-partition	true	string	交易区，可能值: [main，innovation]
         * symbol	true	string	交易对
         * state	true	string	交易对状态；可能值: [online，offline,suspend] online - 已上线；offline - 交易对已下线，不可交易；suspend -- 交易暂停；pre-online - 即将上线
         * value-precision	true	integer	交易对交易金额的精度（小数点后位数）
         * min-order-amt	true	float	交易对限价单最小下单量 ，以基础币种为单位（即将废弃）
         * max-order-amt	true	float	交易对限价单最大下单量 ，以基础币种为单位（即将废弃）
         * limit-order-min-order-amt	true	float	交易对限价单最小下单量 ，以基础币种为单位（NEW）
         * limit-order-max-order-amt	true	float	交易对限价单最大下单量 ，以基础币种为单位（NEW）
         * sell-market-min-order-amt	true	float	交易对市价卖单最小下单量，以基础币种为单位（NEW）
         * sell-market-max-order-amt	true	float	交易对市价卖单最大下单量，以基础币种为单位（NEW）
         * buy-market-max-order-value	true	float	交易对市价买单最大下单金额，以计价币种为单位（NEW）
         * min-order-value	true	float	交易对限价单和市价买单最小下单金额 ，以计价币种为单位
         * max-order-value	false	float	交易对限价单和市价买单最大下单金额 ，以折算后的USDT为单位（NEW）
         * leverage-ratio	true	float	交易对杠杆最大倍数(仅对逐仓杠杆交易对、全仓杠杆交易对、杠杆ETP交易对有效）
         * underlying	false	string	标的交易代码 (仅对杠杆ETP交易对有效)
         * mgmt-fee-rate	false	float	持仓管理费费率 (仅对杠杆ETP交易对有效)
         * charge-time	false	string	持仓管理费收取时间 (24小时制，GMT+8，格式：HH:MM:SS，仅对杠杆ETP交易对有效)
         * rebal-time	false	string	每日调仓时间 (24小时制，GMT+8，格式：HH:MM:SS，仅对杠杆ETP交易对有效)
         * rebal-threshold	false	float	临时调仓阈值 (以实际杠杆率计，仅对杠杆ETP交易对有效)
         * init-nav	false	float	初始净值（仅对杠杆ETP交易对有效）
         * api-trading	true	string	API交易使能标记（有效值：enabled, disabled）
         */

        private String basecurrency;
        private String quotecurrency;
        private Long priceprecision;
        private Long amountprecision;
        private String symbolpartition;
        private String symbol;
        private String state;
        private Long valueprecision;
        private Long minorderamt;
        private Long maxorderamt;
        private Double minordervalue;
        private Long limitorderminorderamt;
        private Long limitordermaxorderamt;
        private Long sellmarketminorderamt;
        private Long sellmarketmaxorderamt;
        private Long buymarketmaxordervalue;
        private String apitrading;
    }
}
