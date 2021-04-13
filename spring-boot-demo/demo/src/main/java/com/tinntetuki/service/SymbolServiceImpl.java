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

import com.tinntetuki.mapper.SymbolMapper;
import com.tinntetuki.model.huobi.Symbol;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tinntetuki
 */
@Service
public class SymbolServiceImpl {
    @Resource
    SymbolMapper symbolMapper;

    public void batchAdd(List<Symbol.DataDTO> data) {
        symbolMapper.deleteAll();
        data.stream().forEach(c -> {
            symbolMapper.insert(c);
        });
        //symbolMapper.addBatch(data);
    }

    public void add(Symbol.DataDTO data){
        symbolMapper.insert(data);
    }
}
