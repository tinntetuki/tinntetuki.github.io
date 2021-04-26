package com.tinntetuiki.learn.juc;

public class SingletonDemo {

    private static volatile SingletonDemo singletonDemo;

    private SingletonDemo(){
        System.out.println("init");
    }

    public static SingletonDemo getInstants(){
        if(singletonDemo == null){
            synchronized (SingletonDemo.class){
                if(singletonDemo == null){
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }


    public static void main(String[] args) {
        for (int i = 0; i< 10000; i++){
            new Thread(()->{
                SingletonDemo singletonDemo = SingletonDemo.getInstants();
            }, "Thread" + i ).start();
        }
    }
}
