package com.tinntetuki.algo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BagTest {
    Bag bag = new Bag();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void knapsack() {
        int max = bag.knapsack(11, 3, new int[]{1,2,3,4,5}, new int[]{5,4,3,2,1});
        Assert.assertEquals(max, 12);
    }

    @Test
    public void change() {
        int count = bag.change(11, new int[]{1,2,3,4,5});
        Assert.assertEquals(count, 3);
    }

    @Test
    public void canPartition() {
        boolean canPartition = bag.canPartition(new int[]{1,2,3,4,5,7});
        Assert.assertTrue(canPartition);
    }
}