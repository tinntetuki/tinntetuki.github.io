package com.tinntetuiki.learn.juc;

public class MyData {

    private volatile int i = 0;

    public  void add(){
        i++;
    }
}
