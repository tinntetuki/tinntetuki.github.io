package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: tinntetuki
 * @Date: 2020/5/20 23:53
 * @Description: 算法-动态规划
 */
public class DynamicProgramming {

    static int fib(int n){
        if (n < 1) {
            return 0;
        }
        int[] memo = new int[n+1];
        return helper(memo, n);
    }

    static int helper(int[] memo, int n){
        if (n ==1 ||n== 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = helper(memo, n-1) +
                helper(memo, n-2);
        return memo[n];
    }


    static int fibDp(int n){
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

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
        for (int i =0; i<dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1+ dp[i-coin]);
            }
        }
        return (dp[amount] == amount + 1) ?  -1: dp[amount];
    }


    public static void main(String[] args) {
        //System.out.println(fib(60000));
        //System.out.println(fibDp(600000000));
        //System.out.println(fibDp(600000000));
        System.out.println(coinChange(Arrays.asList(new Integer[]{1,2,5}), 54));
    }
}
