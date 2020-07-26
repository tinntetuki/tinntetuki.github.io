package com.tinntetuki.algo;

/**
 * 动态规划之背包问题
 *   框架:
 *      for 状态1 in 状态1的所有取值：
 *          for 状态2 in 状态2的所有取值：
 *              for ...
 *                  dp[状态1][状态2][...] = 择优(选择1，选择2...)
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class Bag {

    /**
     * 今天就来说⼀下背包问题吧，就讨论最常说的 0-1 背包问题。描述：
     * 给你⼀个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两
     * 个属性。其中第 i 个物品的重量为 wt[i] ，价值为 val[i] ，现在让你⽤
     * 这个背包装物品，最多能装的价值是多少？
     *
     * 状态：
     *  所以状态有两个，就是「背包的容量」和「可选择的物品」
     *  选择就是「装进背包」或者「不装进背包」
     *
     * @param w 可装载重量为 W 的背包
     * @param n  可装载N 个物品
     * @param wt 第 i 个物品的重量为 wt[i]
     * @param val 第 i 个物品价值为 val[i]
     * @return 最大重量
     */
    int knapsack(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[n+1][w+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - wt[i-1] < 0) {
                    //不放入背包
                    dp[i][j] = dp[i-1][j];
                } else {
                    //如果你没有把这第 i 个物品装⼊背包，那么很显然，最⼤价值 dp[i][w]
                    //应该等于 dp[i-1][w] ，继承之前的结果。
                    //如果你把这第 i 个物品装⼊了背包，那么 dp[i][w] 应该等于 dp[i-1][w
                    //- wt[i-1]] + val[i-1] 。
                    //⾸先，由于 i 是从 1 开始的，所以 val 和 wt 的索引是 i-1 时表⽰第
                    //i 个物品的价值和重量。
                    //⽽ dp[i-1][w - wt[i-1]] 也很好理解：你如果装了第 i 个物品，就要寻
                    //求剩余重量 w - wt[i-1] 限制下的最⼤价值，加上第 i 个物品的价值
                    //val[i-1] 。
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - wt[i-1]] + val[i-1]);
                }
            }
        }
        return dp[n][w];
    }

    /**
     * 第⼀步要明确两点，
     * 「状态」和「选择」。
     * 状态有两个，就是「背包的容量」和「可选择的物品」，选择就是「装进背包」或者「不装进背包」嘛，背包问题的套路都是这样。
     *
     * 若只使⽤前 i 个物品，当背包容量为 j 时，有 dp[i][j] 种⽅法可以装满背包。
     *
     * 如果你不把这第 i 个物品装⼊背包，也就是说你不使⽤ coins[i] 这个⾯
     * 值的硬币，那么凑出⾯额 j 的⽅法数 dp[i][j] 应该等于 dp[i-1][j] ，
     * 继承之前的结果。
     * 如果你把这第 i 个物品装⼊了背包，也就是说你使⽤ coins[i] 这个⾯值
     * 的硬币，那么 dp[i][j] 应该等于 dp[i][j-coins[i-1]] 。
     *
     * @param amount
     * @param coins
     * @return
     */
    int change(int amount, int[] coins){
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
    }

    /**
     * 416. 分割等和子集
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * 注意:
     *
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     *
     * 给⼀个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为
     * nums[i] 。现在让你装物品，是否存在⼀种装法，能够恰好将背包装满？
     *
     * 第⼀步要明确两点，
     * 「状态」和「选择」。
     * 这个前⽂ 经典动态规划：背包问题 已经详细解释过了，状态就是「背包的
     * 容量」和「可选择的物品」，选择就是「装进背包」或者「不装进背包」。
     * 第⼆步要明确 dp 数组的定义。
     * 按照背包问题的套路，可以给出如下定义：
     * dp[i][j] = x 表⽰，对于前 i 个物品，当前背包的容量为 j 时，若 x
     * 为 true ，则说明可以恰好将背包装满，若 x 为 false ，则说明不能恰
     * 好将背包装满。
     *
     * @param nums
     */
    boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

}

