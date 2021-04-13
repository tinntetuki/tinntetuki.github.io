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
public class Tickers {

    /**
     * status : ok
     * ts : 1616238081721
     * data : [{"open":0.044297,"close":0.042178,"low":0.04011,"high":0.045255,"amount":12880.851,"count":12838,"vol":563.038871574,"symbol":"ethbtc","bid":0.007545,"bidSize":0.008,"ask":0.008088,"askSize":0.009},{"open":0.008545,"close":0.008656,"low":0.008088,"high":0.009388,"amount":88056.186,"count":16077,"vol":771.7975953754,"symbol":"ltcbtc","bid":0.007545,"bidSize":0.008,"ask":0.008088,"askSize":0.009}]
     */

    private String status;
    private Long ts;
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    @AllArgsConstructor
    @Builder
    public static class DataDTO {
        /**
         * amount	float	以基础币种计量的交易量（以滚动24小时计）
         * count	integer	交易笔数（以滚动24小时计）
         * open	float	开盘价（以新加坡时间自然日计）
         * close	float	最新价（以新加坡时间自然日计）
         * low	float	最低价（以新加坡时间自然日计）
         * high	float	最高价（以新加坡时间自然日计）
         * vol	float	以报价币种计量的交易量（以滚动24小时计）
         * symbol	string	交易对，例如btcusdt, ethbtc
         * bid	float	买一价
         * bidSize	float	买一量
         * ask	float	卖一价
         * askSize	float	卖一量
         */

        /**
         * open : 0.044297
         * close : 0.042178
         * low : 0.04011
         * high : 0.045255
         * amount : 12880.851
         * count : 12838
         * vol : 563.038871574
         * symbol : ethbtc
         * bid : 0.007545
         * bidSize : 0.008
         * ask : 0.008088
         * askSize : 0.009
         */

        private Double open;
        private Double close;
        private Double low;
        private Double high;
        private Double amount;
        private Integer count;
        private Double vol;
        private String symbol;
        private Double bid;
        private Double bidSize;
        private Double ask;
        private Double askSize;
    }
}
