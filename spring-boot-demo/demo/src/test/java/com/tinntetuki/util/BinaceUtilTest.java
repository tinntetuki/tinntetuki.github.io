package com.tinntetuki.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class BinaceUtilTest {

    @BeforeEach
    void setUp() {
        System.out.println("start test binace api");
    }

    @AfterEach
    void tearDown() {
        System.out.println("test binace api end");
    }

    @Test
    void getTickers() throws IOException {
        BinaceUtil.getTickers();
    }
}