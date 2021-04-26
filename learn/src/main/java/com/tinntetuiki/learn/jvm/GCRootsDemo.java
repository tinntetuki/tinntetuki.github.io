package com.tinntetuiki.learn.jvm;

/**
 * @author: tinn
 * @creat: 2022/1/5 23:12
 * <p>
 * desc: GC Roots
 *
 * 1.栈中的距不变量
 * 2.方法去中的static变量
 * 3.方法区中的常量
 * 4.虚拟机栈
 */

public class GCRootsDemo {
    private static GCRootsDemo demo1;
    private final static GCRootsDemo demo2 = new GCRootsDemo();

    public static void main(String[] args) {
        call();
    }

    private static void call() {
        GCRootsDemo demo = new GCRootsDemo();
        System.gc();

        System.out.println("GC done");
    }
}
