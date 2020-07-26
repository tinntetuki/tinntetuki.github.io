package com.tinntetuki.algo;

import java.util.*;

/**
 * 算法-滑动窗口
 *
 * 建议背诵并默写这套框架，顺便背诵一下文章开头的那首诗。以后就再也不怕子串、子数组问题了好吧。
 *
 * 链表字串数组题，用双指针别犹豫
 * 双指针家三兄弟，各个都是万人迷
 *
 * 快慢指针最神奇，链表操作无压力
 * 归并排序找中点，链表成环搞判定
 *
 * 左右指针最常见，左右两端相向行
 * 反转数组要靠他，二分搜索是弟弟
 *
 * 滑动窗口老猛男，字串问题全靠他
 * 左右指针滑窗口，一前一后齐头进
 * 自称10年老司机，怎料农村道路滑
 * 一不小心滑倒了，鼻清脸肿少颗牙
 * 算法思想很简单，除了bug想升天
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class SlidingWindow {

    /**
     * 算法框架
     * @param s
     * @param t
     */
    public void slidingWindow(String s, String t){
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c= s.charAt(right);
            right ++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c) == need.get(c)) {
                    valid ++;
                }
            }

            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);

                left++;

                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d)) {
                        valid --;
                    }

                    window.put(d, window.getOrDefault(d,0) -1);
                }
            }
        }

        System.out.println(len == Integer.MAX_VALUE ? "" : s.substring(start, len));
    }

    /**
     * LeetCode 76 题，Minimum Window Substring，难度 Hard：
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t){
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c= s.charAt(right);
            right ++;

            System.out.println("window:" + window);
            System.out.println("need:" + need);
            System.out.println("valid:" + valid);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c) == need.get(c)) {
                    valid ++;
                }
            }

            while (valid == need.size()) {
                System.out.println("window2:" + window);
                System.out.println("need2:" + need);
                System.out.println("valid2:" + valid);
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);

                left++;

                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d)) {
                        valid --;
                    }

                    window.put(d, window.getOrDefault(d,0) -1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    /**
     * LeetCode 567 题，Permutation in String，难度 Medium：
     * @param t
     * @param s
     * @return
     */
    public Boolean checkInclusion(String t, String s) {
        // 判断 s 中是否存在 t 的排列
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c= s.charAt(right);
            right ++;

            System.out.println("window:" + window);
            System.out.println("need:" + need);
            System.out.println("valid:" + valid);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c) == need.get(c)) {
                    valid ++;
                }
            }

            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s.charAt(left);

                left++;

                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d)) {
                        valid --;
                    }

                    window.put(d, window.getOrDefault(d,0) -1);
                }
            }
        }

        return false;
    }

    /**
     * 这是 LeetCode 第 438 题，Find All Anagrams in a String，难度 Medium：
     * @param s
     * @param t
     * @return
     */
    public Integer[] findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) +1);
        }

        int left = 0, right = 0;
        int valid  = 0;

        Integer[] res = new Integer[s.length()];
        List<Integer> list = new ArrayList();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0 ) + 1);
                if (window.get(c) == need.get(c)) {
                    valid ++;
                }
            }

            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    list.add(left);
                }

                char d= s.charAt(left);
                left ++ ;
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d)) {
                        valid --;
                    }
                    window.put(d, window.getOrDefault(d, 0) -1);
                }
            }
        }

        System.out.println(list);
        return list.toArray(new Integer[s.length()]);
    }

    /**
     * 这是 LeetCode 第 3 题，Longest Substring Without Repeating Characters，难度 Medium：
     * 最长不重复字符串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left ++;

                window.put(d, window.get(d) -1);
            }

            res = Integer.max(res, right - left);
        }

        return res;
    }
}
