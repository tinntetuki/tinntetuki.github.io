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
package com.tinntetuki.data.DTO.huobi;

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
    public static class DataDTO {
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
