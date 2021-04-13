package com.tinntetuki.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TickersUtilTest{

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getTickers() {
        try {
            TickersUtil.getTickers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}