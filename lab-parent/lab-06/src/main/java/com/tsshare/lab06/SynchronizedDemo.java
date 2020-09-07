package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: SynchronizedDemo
 * @projectName framework-lab
 * @description: 并发问题
 * @date 2020/9/721:43
 */
public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        synchronized (SynchronizedDemo.class) {
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
        }
    }
}
