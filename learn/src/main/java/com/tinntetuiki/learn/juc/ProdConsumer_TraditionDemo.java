package com.tinntetuiki.learn.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: tinn
 * @creat: 2021/12/31 23:28
 *
 * desc: 交替操作一个变量，+1，-1，操作多轮
 *
 * 1 线程    操作(方法)     资源类
 * 2 判断    干活          通知
 * 3 防止虚假唤醒机制
 */

class ShareDate{

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment(){
        lock.lock();
        try {
            while (number != 0){
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName() + "++" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number == 0){
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName() + "--" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }
}

public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                shareDate.increment();
            },"AA").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                shareDate.decrement();
            },"BB").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                shareDate.increment();
            },"CC").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                shareDate.decrement();
            },"DD").start();
        }

    }
}
