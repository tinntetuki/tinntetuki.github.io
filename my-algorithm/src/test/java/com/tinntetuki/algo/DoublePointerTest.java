package com.tinntetuki.algo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoublePointerTest {
    DoublePointer doublePointer = new DoublePointer();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverse() {
        Assert.assertArrayEquals(doublePointer.reverse(new int[]{1,2,3,4}), new int[]{4,3,2,1});
        Assert.assertArrayEquals(doublePointer.reverse(new int[]{1,2,3,4,5}), new int[]{5,4,3,2,1});
    }
}