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
package com.tinntetuki.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tinntetuki.model.huobi.Currencies;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tinntetuki
 */
@Mapper
public interface CurrenciesMapper extends BaseMapper<Currencies> {


    @Delete("truncate table HUOBI_CURRENCY")
    void deleteAll();

    @Insert("INSERT into HUOBI_CURRENCY(CHAIN ,DISPLAYNAME ,BASECHAIN , BASECHAINPROTOCOL,ISDYNAMIC, DEPOSITSTATUS, MAXTRANSACTFEEWITHDRAW," +
            " MAXWITHDRAWAMT,MINDEPOSITAMT,MINTRANSACTFEEWITHDRAW,MINWITHDRAWAMT, NUMOFCONFIRMATIONS , NUMOFFASTCONFIRMATIONS ,WITHDRAWFEETYPE," +
            " WITHDRAWPRECISION, WITHDRAWQUOTAPERDAY, WITHDRAWQUOTAPERYEAR, WITHDRAWQUOTATOTAL, WITHDRAWSTATUS, TRANSACTFEERATEWITHDRAW," +
            " TRANSACTFEEWITHDRAW) values " +
            "(#{currency.chain},\n" +
            "#{currency.displayName},\n" +
            "#{currency.baseChain},\n" +
            "#{currency.baseChainProtocol},\n" +
            "#{currency.isDynamic},\n" +
            "#{currency.depositStatus},\n" +
            "#{currency.maxTransactFeeWithdraw},\n" +
            "#{currency.maxWithdrawAmt},\n" +
            "#{currency.minDepositAmt},\n" +
            "#{currency.minTransactFeeWithdraw},\n" +
            "#{currency.minWithdrawAmt},\n" +
            "#{currency.numOfConfirmations},\n" +
            "#{currency.numOfFastConfirmations},\n" +
            "#{currency.withdrawFeeType},\n" +
            "#{currency.withdrawPrecision},\n" +
            "#{currency.withdrawQuotaPerDay},\n" +
            "#{currency.withdrawQuotaPerYear},\n" +
            "#{currency.withdrawQuotaTotal},\n" +
            "#{currency.withdrawStatus},\n" +
            "#{currency.transactFeeRateWithdraw},\n" +
            "#{currency.transactFeeWithdraw}" +
            "  )")
    int insert(@Param("currency") Currencies.CurrencyDTO.ChainsDTO currency);
}
