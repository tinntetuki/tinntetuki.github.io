package com.tinntetuiki.learn.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: tinn
 * @creat: 2022/1/3 17:13
 * <p>
 * desc: 阻塞队列
 */

public class BlockQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        System.out.println(queue.add("1"));
        System.out.println(queue.add("2"));
        System.out.println(queue.add("3"));
//        System.out.println(queue.add("4"));

//        System.out.println(queue.remove("2"));

        System.out.println(queue.element());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("2"));
        System.out.println(queue.offer("3"));
        System.out.println(queue.offer("4"));

        System.out.println(queue.peek());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.put("1");
        queue.put("2");
        queue.put("3");
//        queue.put("4");

        System.out.println("==========");

        queue.take();
        queue.take();
        queue.take();
//        queue.take();

        queue.offer("1", 2, TimeUnit.SECONDS);
        queue.offer("2", 2, TimeUnit.SECONDS);
        queue.offer("3", 2, TimeUnit.SECONDS);
        queue.offer("4", 2, TimeUnit.SECONDS);

        queue.poll(2, TimeUnit.SECONDS);
        queue.poll(2, TimeUnit.SECONDS);
        queue.poll(2, TimeUnit.SECONDS);
//        queue.poll(2, TimeUnit.SECONDS);

        BlockingQueue blockingQueue = new SynchronousQueue();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();

    }
}
