package com.tinntetuki.algo;

import java.util.Arrays;
import java.util.List;

/**
 * 计算器
 *
 * @Auther: tinntetuki
 */
public class Calculate {

    public int calculate(String str) {
        return helper(str.toCharArray());
    }

    private int helper(char[] toCharArray) {
        /*for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            if (isdigit(c))
                num = 10 * num + (c - '0');
​
            if (!isdigit(c) || i == s.size() - 1) {
                switch (sign) {
                    int pre;
                    case '+':
                        stk.push(num); break;
                    case '-':
                        stk.push(-num); break;
                    // 只要拿出前一个数字做对应运算即可
                    case '*':
                        pre = stk.top();
                        stk.pop();
                        stk.push(pre * num);
                        break;
                    case '/':
                        pre = stk.top();
                        stk.pop();
                        stk.push(pre / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }*/
        return 0;
    }
}
