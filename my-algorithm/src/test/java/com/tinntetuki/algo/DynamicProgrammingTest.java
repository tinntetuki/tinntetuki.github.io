package com.tinntetuki.algo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class DynamicProgrammingTest {
    DynamicProgramming dynamicProgramming = new DynamicProgramming();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void fib_() {
    }

    @Test
    public void fib() {
        dynamicProgramming.fib(60000);
    }

    @Test
    public void helper() {
    }

    @Test
    public void fibDp() {
        dynamicProgramming.fibDp(6000000);
    }

    @Test
    public void fib1() {
    }

    @Test
    public void coinChange() {
        dynamicProgramming.coinChange(Arrays.asList(new Integer[]{1,2,5}), 54);
    }

    @Test
    public void lengthOfLIS() {
    }

    @Test
    public void lengthOfLIS_2() {
        dynamicProgramming.lengthOfLIS_2(new int[]{1,3,5,2,6,7,8,5,4,3});
    }

    @Test
    public void maxSubArray() {
    }

    @Test
    public void knapsack() {
    }

    @Test
    public void canPartition() {
     dynamicProgramming.canPartition(new int[]{1,2,3,4});
    }

    @Test
    public void lengthOfLis() {

    }

    @Test
    public void maxSubArray_1() {
    }
}