package com.tinntetuki.algo;

import java.util.Stack;

/**
 * 计算器
 *
 * @author tinntetuki
 * @since 2020/7/13
 */
public class Calculate {

    /**
     * 字符串转整数
     * @param s
     * @return
     */
    public int getIntValue(String s){
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            n = 10 * n + (c - '0');
        }

        return n;
    }

    /**
     * 加减法
     * @param s
     * @return
     */
    int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        //记录算术中的数字
        int num = 0;
        char sign = '+';

        /*Stack<Character> s1 = new Stack<>();
        for (int i = s.length()-1; i>=0; i--) {
            s1.push(s.charAt(i));
        }*/

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (c == '(') {
                  System.out.println(num);
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                int pre = 0;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                System.out.println(sign + "__" + num);
                sign = c;
                num = 0;
            }
            if (c == ')') {
                break;
            }
        }

        return sum(stack);
    }

    private int sum(Stack<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        //System.out.println(calculate.getIntValue("456"));
        System.out.println(calculate.calculate("(100/2)"));
    }

    public int calculate_1(String str) {
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
