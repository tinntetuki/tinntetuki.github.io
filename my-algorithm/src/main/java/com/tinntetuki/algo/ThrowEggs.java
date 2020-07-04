package com.tinntetuki.algo;

/**
 * 高楼扔鸡蛋问题
 *
 * @Auther: tinntetuki
 */
public class ThrowEggs {

    static int superEggDrop(int k, int n){
        return dp(k, n);
    }

    private static int dp(int k, int n) {
        if (k == 1) return n;
        if (n == 0) return 0;

        //避免重复运算
       /* if (K, N) in memo:
        return memo[(K, N)]

        res = float('INF')
        # 穷举所有可能的选择
        for i in range(1, N + 1):
        res = min(res,
                max(
                        dp(K, N - i),
                        dp(K - 1, i - 1)
                ) + 1
        )
        # 记入备忘录
        memo[(K, N)] = res
        return res*/
        return 0;
    }

    public static void main(String[] args) {

    }
}
