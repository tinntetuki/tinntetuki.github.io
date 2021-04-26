package com.tinntetuiki.learn.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 **
 * @author: tinn
 * @creat: 2021/12/31 23:28
 *
 * java虚拟机提供的轻量级同步机制
 *
 * 1 保证可见性
 * 2 不保证原子性
 * 3 防止指令重排
 *
 * 验证volatile可见性
 *  1.1 假设变量不用volatile修饰，修改后，没有可见性
 *  1.2 加了volatile，有可见性
 *
 * 验证volatile不保证原子性
 *
 *  如何解决原子性
 *    加sync
 *    使用Atomic
 */
public class MyVolatileTest {

    public static void main(String[] args) {
        seeOkByVolatile();

        notAtomicByVolatile();
    }

    /**
     * volatile不保证原子性
     */
    private static void notAtomicByVolatile() {
        Data data = new Data();

        for(int i = 0; i < 20; i++){
            new Thread(()->{
                for (int j = 0; j < 1000; j++){
                    data.addPlusPlus();
                    data.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println("data value is : " + data.i);
        System.out.println("atomic value is : " + data.atomicInteger);
    }

    /**
     * volatile保证可见性
     */
    private static void seeOkByVolatile() {
        Data data = new Data();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\ncome in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e){
                e.printStackTrace();
            }

            data.add();
            System.out.println("AAA update: " + data.i );
        }, "AAA").start();

        while (data.i == 0){
            System.out.println("wait");
        }

        System.out.println("main function end");
        System.out.println("main get value " + data.i);
    }

}

class Data{

    //不加volatile其他线程读取不到更新后的值
    volatile int i = 0;

    void add(){
        this.i = 60;
    }

    void addPlusPlus(){
        i++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}