package com.tinntetuiki.learn.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * CAS  ABA问题
 *
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        Collections.synchronizedList(new ArrayList<>());

        System.out.println();

        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        }, "t1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 2019));
            System.out.println(atomicReference.get());
        }, "t2").start();


        try {
            TimeUnit.SECONDS.sleep(2);

            System.out.println("================   ABA start   =============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "init : "+ stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            atomicStampedReference.compareAndSet(101, 100, stamp+1, stamp + 1 + 1);

            System.out.println(Thread.currentThread().getName() + " : " + atomicStampedReference.getReference().intValue() + " : "+ atomicStampedReference.getStamp());
        }, "t3").start();
        new Thread(()->{

            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "init : "+ stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName() + " : " + atomicStampedReference.getReference().intValue() + " : "+ atomicStampedReference.getStamp());
        }, "t4").start();

    }

}
