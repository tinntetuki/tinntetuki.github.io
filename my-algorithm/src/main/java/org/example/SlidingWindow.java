package org.example;

import java.util.*;

/**
 * @Auther: tinntetuki
 * @Date: 2020/5/20 23:53
 * @Description: 算法-滑动窗口
 */
public class SlidingWindow {

    static void slidingWindow(String s, String t){
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

    static String minWindow(String s, String t){
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


    // 判断 s 中是否存在 t 的排列
    static Boolean checkInclusion(String t, String s) {
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

    static Integer[] findAnagrams(String s, String t) {
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

    static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        //System.out.println(checkInclusion("gwt", "sfasdtgwewtw"));
        System.out.println(findAnagrams("sfasdtgwewgtw", "gwt"));
        System.out.println(lengthOfLongestSubstring("asdfdfdfaagasgeweegdsfghffgsfgvcx"));
    }
}
