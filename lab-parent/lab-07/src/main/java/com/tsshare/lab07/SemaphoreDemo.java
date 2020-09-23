package com.tsshare.lab07;

import lombok.SneakyThrows;

import java.util.concurrent.Semaphore;

/**
 * @author chenzhenfei
 * @title: SemaphoreDemo
 * @projectName framework-lab
 * @description: 共享锁 - Semaphore
 * @date 2020/9/2322:33
 */
public class SemaphoreDemo implements Runnable {
    private static  Semaphore semaphore = new Semaphore(5, true);;
    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(2000);
        semaphore.release();
    }

    public static void main(String[] args) {
        while (true) {
            if(semaphore.tryAcquire()) {
                new Thread(new SemaphoreDemo()).start();
            }
        }

    }

    private static void testSemaphore() {

    }
}
