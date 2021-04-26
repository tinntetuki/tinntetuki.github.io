package com.tinntetuiki.learn.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是什么
 *  比较并交换 compareAndSwap
 *
 * 自旋锁
 * Unsafe
 */
public class CASDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2014) + "\t current data: " + atomicInteger.get());

        atomicInteger.getAndIncrement();

        Collections.synchronizedList(new ArrayList<>());
        //CopyOnWriteArrayList;

        //HashSet;

    }
}
