package com.tinntetuiki.learn.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: tinn
 * @creat: 2022/1/12 21:49
 * <p>
 * desc: GC over head
 * -Xms10m -Xmx10m -XX:PrintGCDetails -XX:MaxDikrectMemorySize=5m
 */

public class GCOverHeadDemo {

    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("=========" + i);
            e.printStackTrace();
        }
    }
}
