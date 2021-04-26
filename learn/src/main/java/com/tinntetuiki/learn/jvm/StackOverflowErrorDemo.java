package com.tinntetuiki.learn.jvm;

/**
 * @author: tinn
 * @creat: 2022/1/12 21:27
 * <p>
 * desc: 栈溢出
 */

public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflow();
    }

    private static void stackOverflow() {
        stackOverflow();
    }
}
