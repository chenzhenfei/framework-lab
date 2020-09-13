package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: WaitDemo
 * @projectName framework-lab
 * @description: wait /notify
 * @date 2020/9/1321:14
 */
public class ThreadWaitDemo {
    private String objLock = "wait";




    public static void main(String[] args) {
        test2();
    }


    private static void test2() {
        ThreadWaitDemo threadWaitDemo = new ThreadWaitDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadWaitDemo.testLockFun1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadWaitDemo.testLockFun2();
            }
        }).start();
    }


    private void testLockFun1() {
        synchronized (objLock) {
            System.out.println(Thread.currentThread().getName() + "：获得锁");
            try {
                objLock.wait();
                System.out.println(Thread.currentThread().getName() + "：重新获得锁");
                objLock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void testLockFun2() {
        synchronized (objLock) {
            System.out.println(Thread.currentThread().getName() + "：获得锁");
            try {
                System.out.println(Thread.currentThread().getName() + "：唤醒其他线程");
                Thread.sleep(2000);
                objLock.notify();
                objLock.wait();
                System.out.println(Thread.currentThread().getName() + "：重新获得锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
