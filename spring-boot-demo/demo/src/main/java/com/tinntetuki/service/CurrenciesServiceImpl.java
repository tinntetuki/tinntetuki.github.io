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
package com.tinntetuki.service;

import com.tinntetuki.mapper.CurrenciesMapper;
import com.tinntetuki.model.huobi.Currencies;
import com.tinntetuki.model.huobi.Symbol;
import com.tinntetuki.util.HuoBiUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author tinntetuki
 */
@Service
public class CurrenciesServiceImpl {
    @Resource
    CurrenciesMapper currenciesMapper;

    public void batchAdd(List<Currencies.CurrencyDTO> data) {
        currenciesMapper.deleteAll();
        data.forEach(c ->{
            c.getChains().forEach(d->{
                currenciesMapper.insert(d);
            });
        });
    }
}
