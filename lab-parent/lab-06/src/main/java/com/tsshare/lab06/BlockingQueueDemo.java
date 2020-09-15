package com.tsshare.lab06;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author chenzhenfei
 * @title: BlockingQueueDemo
 * @projectName framework-lab
 * @description: 阻塞队列
 * @date 2020/9/1522:28
 */
public class BlockingQueueDemo {

    public static void main(String[] args) {
        BlockingQueue blockingQueue =new ArrayBlockingQueue(10,true);
        blockingQueue.offer(1);
    }
}
