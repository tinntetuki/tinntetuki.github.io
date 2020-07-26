package com.tinntetuki.algo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinarySearchTest {
    BinarySearch binarySearch = new BinarySearch();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void binarySearch() {
        Assert.assertEquals(binarySearch.binarySearch(new int[]{1,2,3,4,5,6}, 5), 4);
    }

    @Test
    public void left_bound() {
        Assert.assertEquals(binarySearch.left_bound(new int[]{1,2,3,4,4,4,4,4,5,6}, 4), 3);
    }

    @Test
    public void right_bound() {
        Assert.assertEquals(binarySearch.right_bound(new int[]{1,2,3,4,4,4,4,4,5,6}, 4), 7);
    }
}