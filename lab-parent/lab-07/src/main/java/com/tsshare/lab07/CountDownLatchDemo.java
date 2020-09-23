package com.tsshare.lab07;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author chenzhenfei
 * @title: CountDownLatch
 * @projectName framework-lab
 * @description: 共享锁 - CountDown
 * @date 2020/9/2322:33
 */
public class CountDownLatchDemo implements Runnable {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始");
//        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName()+":结束");
        System.out.println("当前占用资源"+"："+countDownLatch.getCount());
        countDownLatch.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <5 ; i++) {
            new Thread(new CountDownLatchDemo()).start();
        }
        countDownLatch.await();
        System.out.println("已经执行完");
    }
}