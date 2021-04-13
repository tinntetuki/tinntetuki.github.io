package com.tinntetuki.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class HuoBiUtilTest {

    @BeforeEach
    void setUp() {
        System.out.println("start test huobi api");
    }

    @AfterEach
    void tearDown() {
        System.out.println("test huobi api end");
    }

    @Test
    void getTickers() throws IOException {
        HuoBiUtil.getTickers();
    }

    @Test
    void getCurrencies() throws IOException {
        HuoBiUtil.getCurrencies();
    }

    @Test
    void getSymbol() throws IOException {
        HuoBiUtil.getSymbol();
    }

    @Test
    void getAccountDepositAddress() throws IOException {
        //HuoBiUtil.getAccountDepositAddress();
    }

}