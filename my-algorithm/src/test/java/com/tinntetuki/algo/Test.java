package com.tinntetuki.algo;

import org.junit.After;
import org.junit.Before;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

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
        System.out.println(2%5);

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
        while (i < all.length) {
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

    @org.junit.Test
    public void makeGood() {
        String s = "abBAcC";
        Objects.requireNonNull(s);

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (Math.abs(c - stack.peek()) == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        /*sb.length();
        sb.charAt();*/

        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.toString());
        return ;
    }

    @org.junit.Test
    public void test1(){
        System.out.println(String.valueOf('a' - 'A'));
    }

    @org.junit.Test
    public void findKthBit() {
        int n, k, res;
        n = 1;
        k = 1;

        if (n == 1) {
            if (k == 1) {
                res = 0;
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        } else {

        }

        res = 1;
        int[] nums = new int[2];
        int m = nums.length;
        

        System.out.println(res);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1];
        int i = 0, j = 0, r = 0;
        while (i < len1 && j < len2){
            if (nums1[i] == nums2[j]) {
                res[r] = nums1[i];
                i++;
                j++;
                r++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return  Arrays.copyOf(res, r+1);
    }

}
