package org.example;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: tinntetuki
 * @Date: 2020/5/20 23:53
 * @Description: 算法-回溯
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
        System.out.println(track);

        // 触发结束条件
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

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3,4}));
    }
}
