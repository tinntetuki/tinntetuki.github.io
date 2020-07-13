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



    public static void main(String[] args) {
        Bag bag = new Bag();
        System.out.println(bag.knapsack(3,3, new int[]{1,2,3}, new int[]{3,2,6}));
    }

}

