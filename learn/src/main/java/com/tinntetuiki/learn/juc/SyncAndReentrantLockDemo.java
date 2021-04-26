package com.tinntetuiki.learn.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: tinn
 * @creat: 2022/1/3 22:36
 * <p>
 * desc: Lock精确唤醒
 *
 * 三个线程  AAA5次  BBB10次   CCC15次
 * 打印10轮
 */

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            //判断
            while (number != 1){
                c1.await();
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println("AAA" + i);
            }
            //通知
            number = 2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            //判断
            while (number != 2){
                c2.await();
            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println("BBB" + i);
            }
            //通知
            number = 3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            //判断
            while (number != 3){
                c3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println("CCC" + i);
            }
            //通知
            number = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class SyncAndReentrantLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();

            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();

            }
        }, "C").start();
    }
}
