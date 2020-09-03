package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: InterruptStatusDemo
 * @projectName framework-lab
 * @description: 线程的中断状态
 * @date 2020/9/321:33
 */
public class InterruptStatusDemo {

    public static void main(String[] args) {
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        //busyThread一直执行死循环
        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true){

                }
            }
        };

        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while (sleepThread.isInterrupted()) {}
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}
