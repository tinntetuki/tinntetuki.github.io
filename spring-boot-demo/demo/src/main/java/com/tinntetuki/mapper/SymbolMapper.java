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
import com.tinntetuki.model.huobi.Symbol;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tinntetuki
 */
@Mapper
public interface SymbolMapper extends BaseMapper<Symbol> {

    /**
     * 插入
     * @param symbols
     * @return
     */
    @Insert(" insert into HUOBI_SYMBOL(BASECURRENCY,QUOTECURRENCY,PRICEPRECISION,AMOUNTPRECISION," +
            "SYMBOLPARTITION,SYMBOL,STATE,VALUEPRECISION,MINORDERAMT,MAXORDERAMT,MINORDERVALUE," +
            "LIMITORDERMINORDERAMT,LIMITORDERMAXORDERAMT,SELLMARKETMINORDERAMT,SELLMARKETMAXORDERAMT," +
            "BUYMARKETMAXORDERVALUE,APITRADING) values" +
            "        <foreach collection=\"symbols\" item=\"symbol\" separator=\",\">" +
            "            (#{symbol.basecurrency},#{symbol.quotecurrency},#{symbol.priceprecision}," +
            "             #{symbol.amountprecision},#{symbol.symbolpartition},#{symbol.symbol}," +
            "             #{symbol.state},#{symbol.valueprecision},#{symbol.minorderamt}," +
            "             #{symbol.maxorderamt},#{symbol.minordervalue},#{symbol.limitorderminorderamt}," +
            "             #{symbol.limitordermaxorderamt},#{symbol.sellmarketminorderamt}," +
            "           #{symbol.sellmarketmaxorderamt},#{symbol.buymarketmaxordervalue},#{symbol.apitrading})" +
            "        </foreach>")
    public int addBatch(@Param("symbols") List<Symbol.DataDTO> symbols);

    @Insert(
            " insert into HUOBI_SYMBOL(BASECURRENCY,QUOTECURRENCY,PRICEPRECISION,AMOUNTPRECISION," +
                    "SYMBOLPARTITION,SYMBOL,STATE,VALUEPRECISION,MINORDERAMT,MAXORDERAMT,MINORDERVALUE," +
                    "LIMITORDERMINORDERAMT,LIMITORDERMAXORDERAMT,SELLMARKETMINORDERAMT,SELLMARKETMAXORDERAMT," +
                    "BUYMARKETMAXORDERVALUE,APITRADING) values" +
                    " (#{symbol.basecurrency},#{symbol.quotecurrency},#{symbol.priceprecision}," +
                    "  #{symbol.amountprecision},#{symbol.symbolpartition},#{symbol.symbol}," +
                    "  #{symbol.state},#{symbol.valueprecision},#{symbol.minorderamt}," +
                    "  #{symbol.maxorderamt},#{symbol.minordervalue},#{symbol.limitorderminorderamt}," +
                    "  #{symbol.limitordermaxorderamt},#{symbol.sellmarketminorderamt}," +
                    "  #{symbol.sellmarketmaxorderamt},#{symbol.buymarketmaxordervalue},#{symbol.apitrading})"
    )
    public int insert(@Param("symbol") Symbol.DataDTO data);

    @Delete("truncate table HUOBI_SYMBOL")
    void deleteAll();
}
