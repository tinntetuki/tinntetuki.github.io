package com.tinntetuki.algo;

import org.junit.After;
import org.junit.Before;

import java.util.Arrays;
import java.util.Objects;

/**
 * 测试一些自己的想法
 *
 * @author tinntetuki
 * @since 2020/7/26
 */
public class Test {
    private int[] all;
    private int[] used;

    @Before
    public void setUp() throws Exception {
        all = new int[]{1,2,3,4,5,6,7,8,9};
        used = new int[]{1,3,5,7};
    }

    @org.junit.Test
    public void test(){
        System.out.println(3 ^ 3);
        System.out.println(3 ^ 4);

        System.out.println(3 | 3);
        System.out.println(3 | 4);

        System.out.println(3 & 3);
        System.out.println(1 & 4);

        System.out.println(1>>2);
        System.out.println(1<<2);

        System.out.println(8>>>2);
    }

    @org.junit.Test
    public void unUsed() {
        Objects.requireNonNull(all);
        if (used.length == 0) {
            return;
        }

        int i = 0, j = 0;
        while (i < all.length){
            if (j < used.length && all[i] == used[j]) {
                i++;
                j++;
            } else {
                all[i - j] = all[i];
                i++;
            }
        }

        all =  Arrays.copyOf(all, all.length - j);
    }

    @After
    public void tearDown() throws Exception {
        for (int i : all){
            System.out.println(i);
        }
    }
}
