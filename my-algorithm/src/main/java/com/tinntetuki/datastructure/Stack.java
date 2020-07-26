package com.tinntetuki.datastructure;

/**
 * 一句话描述
 *
 * @author tinntetuki
 * @since 2020/7/18
 */
public class Stack {
    /**
     * 给你⼀个数组，返回⼀个等
     * ⻓的数组，对应索引存储着下⼀个更⼤元素，如果没有更⼤的元素，就存
     * -1。
     * @param nums
     * @return
     */
    int[] nextGreaterElement(int[] nums){
        int n = nums.length;
        int[] ans = new int[nums.length];
        java.util.Stack<Integer> s = new java.util.Stack<>();//这⾥放元素索引，⽽不是元素

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.pop() <= nums[i % n]){
                s.pop();
            }

            ans[i] = s.isEmpty() ? -1 : s.pop();// 得到索引间距
            s.push(nums[i]);// 加⼊索引，⽽不是元素

        }

        return ans;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.nextGreaterElement(new int[]{2,1,2,4,3}));
    }
}
