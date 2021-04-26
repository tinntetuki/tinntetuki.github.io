package com.tinntetuiki.learn.juc;

import com.tinn.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * 秦灭六国，一统江山
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        closeDoor();
    }

    private static void closeDoor() {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++){
            new Thread(()->{
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + ": out");
            }, CountryEnum.getByIndex(i).getRetMessage()).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "close door");
    }
}
