package com.tinntetuiki.learn.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: tinn
 * @creat: 2022/1/1 22:56
 *
 * desc: 集合类不安全问题
 */

public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(1,2,3);
        //List<String> list = new ArrayList<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        Collections.synchronizedSet(new HashSet<>());
        Collections.synchronizedMap(new HashMap<>());
        new CopyOnWriteArraySet();

        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, i + "").start();
        }

        //java.util.ConcurrentModificationException


        /**
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         * 2 导致原因
         *
         * 3 解决方案
         *      Vector
         *      Collections.synchronizedList
         *      CopyOnWriteArrayList
         * 4 优化建议
         */
    }

}
