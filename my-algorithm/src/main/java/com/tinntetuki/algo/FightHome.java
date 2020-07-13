package com.tinntetuki.algo;

import java.util.Arrays;

/**
 * 算法-打家劫舍
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class FightHome {
    // 主函数
    static public int rob(int[] nums) {
        return dp(nums, 0);
    }
    // 返回 nums[start..] 能抢到的最大值
    static private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        int res = Math.max(
            // 不抢，去下家
            dp(nums, start + 1),
            // 抢，去下下家
            nums[start] + dp(nums, start + 2)
        );
        return res;
    }

    private int[] memo;
    // 主函数
    public int rob_1(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp_1(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    private int dp_1(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1) {
            return memo[start];
        }

        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }

    int rob_2(int[] nums) {
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        int dp_i_1 = 0, dp_i_2 = 0;
        // 记录 dp[i]
        int dp_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    /**
     * House Robber II
     * 这道题目和第一道描述基本一样，强盗依然不能抢劫相邻的房子，输入依然是一个数组，但是告诉你这些房子不是一排，而是围成了一个圈。
     * 也就是说，现在第一间房子和最后一间房子也相当于是相邻的，不能同时抢。比如说输入数组 nums=[2,3,2]，算法返回的结果应该是 3 而不是 4，因为开头和结尾不能同时被抢。
     * @param nums
     * @return
     */
    public int rob_3(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2),
                robRange(nums, 1, n - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    /**
     * House Robber III
     * 第三题又想法设法地变花样了，此强盗发现现在面对的房子不是一排，不是一圈，而是一棵二叉树！
     * 房子在二叉树的节点上，相连的两个房子不能同时被抢劫，果然是传说中的高智商犯罪：
     * @param root
     */
    int rob(Node root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
    arr[0] 表示不抢 root 的话，得到的最大钱数
    arr[1] 表示抢 root 的话，得到的最大钱数 */
    int[] dp(Node root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1])
                + Math.max(right[0], right[1]);

        return new int[]{not_rob, rob};
    }


    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,3,4,2,4,2,2}));
    }
}
