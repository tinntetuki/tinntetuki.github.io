package com.tinntetuki.algo;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 算法-回溯
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class Backtracking {
    static List<List<Integer>> res  = new LinkedList<>();
    
    static List<List<Integer>> permute(int[] nums){
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     * @param nums
     * @param track
     */
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        //System.out.println(track);

        /// 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<Integer>(track));
            return;
        }

        for (int i=0; i < nums.length; i++) {
            System.out.println(track);
            // 排除不合法的选择
            if (track.contains(nums[i])){
                continue;
            }

            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    static Stack<String> generateParenthesis(int n) {
        if (n == 0) {
            return new Stack<String>();
        }
        // 记录所有合法的括号组合
        Stack<String> res = new Stack<>();
        // 回溯过程中的路径
        String track = "";
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    private static void backtrack(int left, int right, String track, Stack<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) {
            return;
        }
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) {
            return;
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.push(track);
            return;
        }

        // 尝试放一个左括号
        track += "("; // 选择
        backtrack(left - 1, right, track, res);
        track = track.substring(0, track.length() -1); // 撤消选择

        // 尝试放一个右括号
        track += ")"; // 选择
        backtrack(left, right - 1, track, res);
        track = track.substring(0, track.length() -1); // 撤消选择
    }

    public static void main(String[] args) {
        ///System.out.println(permute(new int[]{1,2,3,4}));
        Stack<String> res= generateParenthesis(3);
        res.forEach(c -> {
            System.out.println(c);
        });
    }
}
