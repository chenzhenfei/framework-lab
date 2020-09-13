package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: WaitDemo
 * @projectName framework-lab
 * @description: wait /notify    wait 会让当前获得锁得线程进入等待队列（waitting）,
 *                             ：notify 启动之后会唤醒 waitting 中得一个线程，进入一个同步队列中，等待获取锁
 *                             ：notifyAll 启动之后会将所有watting所有得线程唤醒，进入到同步队列中等待，排队获取锁
 *
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
                //调用 notify 后，当前线程不会马上释放该对象锁，要等到程序退出同步块后，当前线程才会释放锁。
                objLock.notify();
                objLock.wait();
                System.out.println(Thread.currentThread().getName() + "：重新获得锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
