package com.tinntetuiki.learn.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: tinn
 * @creat: 2022/1/1 23:58
 * <p>
 * desc: 可重入锁
 */

class Phone implements Runnable{
    ReentrantLock lock = new ReentrantLock();
    public synchronized void sendSMS() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "\t invoke sendSMS()");
        TimeUnit.SECONDS.sleep(3);
        sendEmail();
    }

    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName() + "\t invoke sendEmail()");
    }

    @Override
    public void run() {
        get();
    }

    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoke get()");
            TimeUnit.SECONDS.sleep(1);
            set();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoke set()");
        }finally {
            lock.unlock();
        }
    }
}

public class ReenterLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        TimeUnit.SECONDS.sleep(5);

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();
    }
}
