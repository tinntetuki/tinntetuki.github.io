package com.tinntetuiki.learn.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {

    private volatile Map<String, Object> map = new HashMap<String, Object>();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value){
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "write in :" + key);
            map.put(key, value);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "write out :" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        reentrantReadWriteLock.readLock().lock();
        try {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "read in " + key);
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "read out " + map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0;i<10;i++){
            int temp = i;
            new Thread(()->{
                myCache.put(temp + "", temp);
            }, i+"").start();
        }

        for (int i = 0;i<10;i++){
            int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            }, i+"").start();
        }
    }
}
