package com.tinntetuiki.learn.jvm;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author: tinn
 * @creat: 2022/1/12 22:03
 * <p>
 * desc: 本地内存溢出  NIO程序比较常见
 */

public class DirectBufferMemoryDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Max DirectBufferMemory" + sun.misc.VM.maxDirectMemory() /1024/1024 + "M");

        TimeUnit.SECONDS.sleep(5);

        ByteBuffer bf = ByteBuffer.allocateDirect(10*1024*1024);
    }
}
