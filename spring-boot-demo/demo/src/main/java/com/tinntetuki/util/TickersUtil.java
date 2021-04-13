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

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.tinntetuki.data.bean.TickerBO;
import com.tinntetuki.model.huobi.Tickers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tinntetuki
 */
public class TickersUtil {
    static void getTickers() throws Exception{
        Map tickersMap = Maps.newHashMap();

        Multimap map = TreeMultimap.create();

        Tickers tickers = HuoBiUtil.getTickers();
        tickers.getData().forEach(c->{
            map.put(c.getSymbol().toLowerCase(), TickerBO.builder()
                    .name("huobi")
                    .value(c.getClose())
                    .build());
        });

        List<com.tinntetuki.model.binace.Tickers> binaceTickers = BinaceUtil.getTickers();
        binaceTickers.forEach(c ->{
            map.put(c.getSymbol().toLowerCase(),  TickerBO.builder()
                    .name("binace")
                    .value(c.getPrice())
                    .build());
        });

        /*map.asMap().forEach((k,v) -> {
            List<TickerBO> bos = (List<TickerBO>) v;
        });*/

        Iterator<Map.Entry<String, Collection<TickerBO>>> iterator = map.asMap().entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Collection<TickerBO>> entry = iterator.next();
            int size = entry.getValue().size() -1;
            if(entry.getValue().size() > 1){
                String symbol = entry.getKey();
              /*  if(!entry.getKey().endsWith("usdt")){
                    continue;
                }*/

                TickerBO min = entry.getValue().stream().findFirst().orElse(new TickerBO());
                TickerBO max = entry.getValue().stream().collect(Collectors.toList()).get(size);
                BigDecimal p = new BigDecimal((max.getValue() - min.getValue())/ min.getValue() * 100);

                if(p.compareTo(BigDecimal.valueOf(50000))>0){
                    continue;
                }
                if(p.compareTo(BigDecimal.valueOf(5))>0){
                    System.out.println(entry.getKey());
                    System.out.println(max.getName() + "_" + min.getName()  + "_" + new BigDecimal(max.getValue())  + "_" + new BigDecimal(min.getValue()));
                    System.out.println(p);

                    /*if("huobi".equals(min.getName())){
                        try {
                            System.out.println(HuoBiUtil.getAccountDepositAddress(symbol));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }*/
                }
            }
        }
        /*map.forEach((k,v)->{
            tickersMap.
        });*/

    }
}
