package com.tinntetuki.algo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.tinntetuki.datastructure.array.Array;

import java.util.Arrays;
import java.util.List;

/**
 * 算法框架
 * # 初始化 base case
 * dp[0][0][...] = base
 * # 进行状态转移
 * for 状态1 in 状态1的所有取值：
 *     for 状态2 in 状态2的所有取值：
 *         for ...
 *             dp[状态1][状态2][...] = 求最值(选择1，选择2...)
 *
 *
 * @Auther: tinntetuki
 * @Date: 2020/5/20 23:53
 * @Description: 算法-动态规划
 */
public class DynamicProgramming {

    /**
     * 斐波那契数列
     * 1.暴力递归
     * @param N
     * @return
     */
    static int fib_(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 带备忘录的递归解法
     * @param n
     * @return
     */
    static int fib(int n){
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n+1];
        return helper(memo, n);
    }

    static int helper(int[] memo, int n){
        if (n ==1 || n== 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = helper(memo, n-1) +
                helper(memo, n-2);
        return memo[n];
    }

    /**
     * 3带备忘录的递归解法 dp 数组的迭代解法
     * @param n
     * @return
     */
    static int fibDp(int n){
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 优化
     * @param n
     * @return
     */
    static int fib1(int n){
        if (n==1 || n==2) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i=3; i<=n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    /**
     * 凑零钱问题
     * @param coins
     * @param amount
     * @return
     */
    static int coinChange(List<Integer> coins, int amount){
        int[] dp = new int[amount+1];
        for (int i =0; i<dp.length; i++) {
            dp[i] = amount +1;
        }
        dp[0] = 0;
        //dp[i] = x 表示，当目标金额为 i 时，至少需要 x 枚硬币。
        // 外层 for 循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                //子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     *
     * 最长递增子序列
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);

        //找到之前比当前值小的最长子序列，将长度+1为当前的最长子序列的长度
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int res = 0;
        //找到最大的子序列长度
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int lengthOfLIS_2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }

    /**
     * 动态规划设计：最大子数组
     * @param nums
     */
    static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;

        for (int i = 1; i < n; i++) {
            // dp[i] = max(nums[i], nums[i] + dp[i-1])
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            // 顺便计算最大的结果
            res = Math.max(res, dp_1);

            System.out.println("i: " + i + "dp_0: " + dp_0 + "res: " + res);
        }

        return res;
    }

    /**
     * 经典动态规划：0-1 背包问题
     * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
     * @param
     */
    static int knapsack (int W, int N, int[] wt, int[] val){
        //int knapsack(int W, int N, vector<int>& wt, vector<int>& val) {
        //    // base case 已初始化
        //    vector<vector<int>> dp(N + 1, vector<int>(W + 1, 0));
        //    for (int i = 1; i <= N; i++) {
        //        for (int w = 1; w <= W; w++) {
        //            if (w - wt[i-1] < 0) {
        //                // 这种情况下只能选择不装入背包
        //                dp[i][w] = dp[i - 1][w];
        //            } else {
        //                // 装入或者不装入背包，择优
        //                dp[i][w] = max(dp[i - 1][w - wt[i-1]] + val[i-1],
        //                               dp[i - 1][w]);
        //            }
        //        }
        //    }
        //
        //    return dp[N][W];
        //}
        return 0;
    }

    /**
     * 子集背包问题
     * 416.分割等和子集
     * @param nums
     */
    static Boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum = sum / 2;

        Boolean[] dp = new Boolean[sum+1];
        Arrays.fill(dp, false);
        // base case
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--){
                if (j - nums[i] >= 0) {
                    System.out.println("----" + dp[j] +"" + dp[j - nums[i]]);
                    dp[j] = dp[j] || dp[j - nums[i]];
                    System.out.println(dp[j]);
                }

                System.out.println("i：" + i);
                System.out.println("j：" + j);
                System.out.println("nums[i]：" + nums[i]);
            }
        }


        return dp[sum];
    }

    public int lengthOfLis(int[] nums){
        int[] dp = new int[nums.length];
        //dp 数组全部初始化为1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(dp[i], res);
        }

        return res;
    }

    int maxSubArray_1(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }

        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;

        for (int i = 1; i < n; i++){
            // 状态转移方程
            dp_1 = Math.max(nums[i], dp_0 + nums[i]);
            dp_0 = dp_1;
            // 得到 nums 的最大子数组
            res = Math.max(dp_1, res);
        }

        return res;
    }




    public static void main(String[] args) {
        //System.out.println(fib(60000));
        //System.out.println(fibDp(600000000));
        //System.out.println(fibDp(600000000));
        //System.out.println(coinChange(Arrays.asList(new Integer[]{1,2,5}), 54));
        //System.out.println(lengthOfLIS_2(new int[]{1,3,5,2,6,7,8,5,4,3}));

        System.out.println(canPartition(new int[]{1,2,3,4}));
    }
}
