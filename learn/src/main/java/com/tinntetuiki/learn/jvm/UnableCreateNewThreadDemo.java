package com.tinntetuiki.learn.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author: tinn
 * @creat: 2022/1/13 21:03
 * <p>
 * desc:
 */

public class UnableCreateNewThreadDemo {

    public static void main(String[] args) {

        for (int i = 0;  ; i++) {
            System.out.println(i);

            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "" + i).start();
        }
    }
}
