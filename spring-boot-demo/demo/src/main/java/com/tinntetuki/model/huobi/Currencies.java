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
public class Currencies {

    /**
     * code : 200
     * data : [{"chains":[{"chain":"trc20usdt","displayName":"","baseChain":"TRX","baseChainProtocol":"TRC20","isDynamic":false,"depositStatus":"allowed","maxTransactFeeWithdraw":"1.00000000","maxWithdrawAmt":"280000.00000000","minDepositAmt":"100","minTransactFeeWithdraw":"0.10000000","minWithdrawAmt":"0.01","numOfConfirmations":999,"numOfFastConfirmations":999,"withdrawFeeType":"circulated","withdrawPrecision":5,"withdrawQuotaPerDay":"280000.00000000","withdrawQuotaPerYear":"2800000.00000000","withdrawQuotaTotal":"2800000.00000000","withdrawStatus":"allowed"},{"chain":"usdt","displayName":"","baseChain":"BTC","baseChainProtocol":"OMNI","isDynamic":false,"depositStatus":"allowed","maxWithdrawAmt":"19000.00000000","minDepositAmt":"0.0001","minWithdrawAmt":"2","numOfConfirmations":30,"numOfFastConfirmations":15,"transactFeeRateWithdraw":"0.00100000","withdrawFeeType":"ratio","withdrawPrecision":7,"withdrawQuotaPerDay":"90000.00000000","withdrawQuotaPerYear":"111000.00000000","withdrawQuotaTotal":"1110000.00000000","withdrawStatus":"allowed"},{"chain":"usdterc20","displayName":"","baseChain":"ETH","baseChainProtocol":"ERC20","isDynamic":false,"depositStatus":"allowed","maxWithdrawAmt":"18000.00000000","minDepositAmt":"100","minWithdrawAmt":"1","numOfConfirmations":999,"numOfFastConfirmations":999,"transactFeeWithdraw":"0.10000000","withdrawFeeType":"fixed","withdrawPrecision":6,"withdrawQuotaPerDay":"180000.00000000","withdrawQuotaPerYear":"200000.00000000","withdrawQuotaTotal":"300000.00000000","withdrawStatus":"allowed"}],"currency":"usdt","instStatus":"normal"}]
     */

    private Long code;
    private List<CurrencyDTO> data;

    @NoArgsConstructor
    @Data
    public static class CurrencyDTO {
        /**
         * chains : [{"chain":"trc20usdt","displayName":"","baseChain":"TRX","baseChainProtocol":"TRC20","isDynamic":false,"depositStatus":"allowed","maxTransactFeeWithdraw":"1.00000000","maxWithdrawAmt":"280000.00000000","minDepositAmt":"100","minTransactFeeWithdraw":"0.10000000","minWithdrawAmt":"0.01","numOfConfirmations":999,"numOfFastConfirmations":999,"withdrawFeeType":"circulated","withdrawPrecision":5,"withdrawQuotaPerDay":"280000.00000000","withdrawQuotaPerYear":"2800000.00000000","withdrawQuotaTotal":"2800000.00000000","withdrawStatus":"allowed"},{"chain":"usdt","displayName":"","baseChain":"BTC","baseChainProtocol":"OMNI","isDynamic":false,"depositStatus":"allowed","maxWithdrawAmt":"19000.00000000","minDepositAmt":"0.0001","minWithdrawAmt":"2","numOfConfirmations":30,"numOfFastConfirmations":15,"transactFeeRateWithdraw":"0.00100000","withdrawFeeType":"ratio","withdrawPrecision":7,"withdrawQuotaPerDay":"90000.00000000","withdrawQuotaPerYear":"111000.00000000","withdrawQuotaTotal":"1110000.00000000","withdrawStatus":"allowed"},{"chain":"usdterc20","displayName":"","baseChain":"ETH","baseChainProtocol":"ERC20","isDynamic":false,"depositStatus":"allowed","maxWithdrawAmt":"18000.00000000","minDepositAmt":"100","minWithdrawAmt":"1","numOfConfirmations":999,"numOfFastConfirmations":999,"transactFeeWithdraw":"0.10000000","withdrawFeeType":"fixed","withdrawPrecision":6,"withdrawQuotaPerDay":"180000.00000000","withdrawQuotaPerYear":"200000.00000000","withdrawQuotaTotal":"300000.00000000","withdrawStatus":"allowed"}]
         * currency : usdt
         * instStatus : normal
         */

        private String currency;
        private String instStatus;
        private List<ChainsDTO> chains;

        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        @Data
        public static class ChainsDTO {
            /**
             * chain : trc20usdt
             * displayName :
             * baseChain : TRX
             * baseChainProtocol : TRC20
             * isDynamic : false
             * depositStatus : allowed
             * maxTransactFeeWithdraw : 1.00000000
             * maxWithdrawAmt : 280000.00000000
             * minDepositAmt : 100
             * minTransactFeeWithdraw : 0.10000000
             * minWithdrawAmt : 0.01
             * numOfConfirmations : 999
             * numOfFastConfirmations : 999
             * withdrawFeeType : circulated
             * withdrawPrecision : 5
             * withdrawQuotaPerDay : 280000.00000000
             * withdrawQuotaPerYear : 2800000.00000000
             * withdrawQuotaTotal : 2800000.00000000
             * withdrawStatus : allowed
             * transactFeeRateWithdraw : 0.00100000
             * transactFeeWithdraw : 0.10000000
             */

            private String chain;
            private String displayName;
            private String baseChain;
            private String baseChainProtocol;
            private Boolean isDynamic;
            private String depositStatus;
            private String maxTransactFeeWithdraw;
            private String maxWithdrawAmt;
            private String minDepositAmt;
            private String minTransactFeeWithdraw;
            private String minWithdrawAmt;
            private Long numOfConfirmations;
            private Long numOfFastConfirmations;
            private String withdrawFeeType;
            private Long withdrawPrecision;
            private String withdrawQuotaPerDay;
            private String withdrawQuotaPerYear;
            private String withdrawQuotaTotal;
            private String withdrawStatus;
            private String transactFeeRateWithdraw;
            private String transactFeeWithdraw;
        }

        /**
         * code	true	int	状态码
         * message	false	string	错误描述（如有）
         * data	true	object
         * { currency	true	string	币种
         * { chains	true	object
         * chain	true	string	链名称
         * displayName	true	string	链显示名称
         * baseChain	false	string	底层链名称
         * baseChainProtocol	false	string	底层链协议
         * isDynamic	false	boolean	是否动态手续费（仅对固定类型有效，withdrawFeeType=fixed）	true,false
         * numOfConfirmations	true	int	安全上账所需确认次数（达到确认次数后允许提币）
         * numOfFastConfirmations	true	int	快速上账所需确认次数（达到确认次数后允许交易但不允许提币）
         * minDepositAmt	true	string	单次最小充币金额
         * depositStatus	true	string	充币状态	allowed,prohibited
         * minWithdrawAmt	true	string	单次最小提币金额
         * maxWithdrawAmt	true	string	单次最大提币金额
         * withdrawQuotaPerDay	true	string	当日提币额度（新加坡时区）
         * withdrawQuotaPerYear	true	string	当年提币额度
         * withdrawQuotaTotal	true	string	总提币额度
         * withdrawPrecision	true	int	提币精度
         * withdrawFeeType	true	string	提币手续费类型（特定币种在特定链上的提币手续费类型唯一）	fixed,circulated,ratio
         * transactFeeWithdraw	false	string	单次提币手续费（仅对固定类型有效，withdrawFeeType=fixed）
         * minTransactFeeWithdraw	false	string	最小单次提币手续费（仅对区间类型和有下限的比例类型有效，withdrawFeeType=circulated or ratio）
         * maxTransactFeeWithdraw	false	string	最大单次提币手续费（仅对区间类型和有上限的比例类型有效，withdrawFeeType=circulated or ratio）
         * transactFeeRateWithdraw	false	string	单次提币手续费率（仅对比例类型有效，withdrawFeeType=ratio）
         * withdrawStatus}	true	string	提币状态	allowed,prohibited
         * instStatus }	true	string	币种状态	normal,delisted
         */
    }
}
