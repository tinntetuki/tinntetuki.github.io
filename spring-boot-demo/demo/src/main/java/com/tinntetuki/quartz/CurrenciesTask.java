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
package com.tinntetuki.quartz;

import com.tinntetuki.model.huobi.Currencies;
import com.tinntetuki.service.CurrenciesServiceImpl;
import com.tinntetuki.util.HuoBiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author tinntetuki
 */
@Slf4j
@Component
public class CurrenciesTask {
    @Autowired
    CurrenciesServiceImpl currenciesService;

    @Scheduled(fixedRate = 24*60*60*1000)
    protected void executeInternal() {
        try {
            Currencies currencies = HuoBiUtil.getCurrencies();
            try {
                currenciesService.batchAdd(currencies.getData());
            } catch (Exception e) {
                log.error("插入symbol错误", e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
