package com.tinntetuiki.learn.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: tinn
 * @creat: 2022/1/3 23:22
 * <p>
 * desc: CallAble Demo
 */

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("callable come in");
        return 1024;
    }
}

public class CallAbleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread t1 = new Thread();
//        t1.start();

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        Thread t2 = new Thread(futureTask, "AA");
        t2.start();

        System.out.println(futureTask.get());
    }

}
