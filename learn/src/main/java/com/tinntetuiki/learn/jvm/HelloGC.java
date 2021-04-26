package com.tinntetuiki.learn.jvm;

/**
 * @author: tinn
 * @creat: 2022/1/6 21:19
 * <p>
 * desc: GC
 *
 *
 * -XX:  boolean类型  -XX:+/-  是否开启某个参数
 *       KV类型
 *       java -XX:+PrintFlagsInitial
 *       java -XX:+PrintFlagsFinal      =初始值，没被修改过   :=又被JVM修改过或者手动修改过
 *
 */

public class HelloGC {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("-------------HelloGC");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
