package com.tsshare.lab07;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

/**
 * @author chenzhenfei
 * @title: CyclicBarrier
 * @projectName framework-lab
 * @description: 共享锁 - CyclicBarrier
 * @date 2020/9/2323:19
 */
public class CyclicBarrierDemo implements Runnable {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+":"+cyclicBarrier.getNumberWaiting());
        //等待其他的线程到达重点一起结束 结束
        cyclicBarrier.await();

    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            new Thread(new CyclicBarrierDemo()).start();
        }
        System.out.println("已经提交完");
    }
}
