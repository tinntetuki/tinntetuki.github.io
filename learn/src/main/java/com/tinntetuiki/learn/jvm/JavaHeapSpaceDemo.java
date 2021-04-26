package com.tinntetuiki.learn.jvm;

/**
 * @author: tinn
 * @creat: 2022/1/12 21:31
 * <p>
 * desc: 堆溢出
 */

public class JavaHeapSpaceDemo {

    public static void main(String[] args) {
//        String str = "heap space";
//
//        while (true){
//            str += str + new Random();
//            System.out.println(str);
//        }

        byte[] bytes = new byte[1024 * 1024 * 80];
    }
}
