package com.tinntetuiki.learn.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: tinn
 * @creat: 2022/1/4 21:25
 * <p>
 * desc: 线程池
 */

public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池固定线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池一个线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();//一池多个线程
        ExecutorService threadPool = new ThreadPoolExecutor(3, 10, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));//一池多个线程

        try {
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + ": " + finalI);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
