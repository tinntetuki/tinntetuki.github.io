package com.tinntetuiki.learn.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: tinn
 * @creat: 2022/1/3 22:56
 * <p>
 * desc: 生产者消费者
 *
 * Volatile/CAS/AtomicInteger/BlockingQueue/线程交互/原子引用
 */

class MyResource{

    private volatile  boolean FLAG = true;//默认开启生产消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;

        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws InterruptedException {
        String data = null;
        boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);

            if(retValue){
                System.out.println(Thread.currentThread().getName() + "offer  success");
            } else {
                System.out.println(Thread.currentThread().getName() + "offer fail");
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "stop");
    }

    public void myConsumer() throws InterruptedException {
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName() +"poll stop");
                System.out.println("");
                System.out.println("");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "poll: " + result + " success");
        }

    }

    public void stop(){
        this.FLAG = false;
    }

}

public class ProdConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(()->{
            System.out.println("Prod start");
            try {
                myResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
            System.out.println("");
        }, "Prod").start();

        new Thread(()->{
            System.out.println("Consumer start");
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
            System.out.println("");
        }, "Prod").start();

        TimeUnit.SECONDS.sleep(5);
        myResource.stop();
    }
}
