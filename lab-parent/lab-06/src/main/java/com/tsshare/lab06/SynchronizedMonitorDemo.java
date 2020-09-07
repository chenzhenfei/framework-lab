package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: SynchronizedMonitorDemo
 * @projectName framework-lab
 * @description: 同步锁监视器  synchronized 是存在线程阻塞和唤醒的，效率低下，但是cas就不一样，cas 可以让线程自旋（死循环）不至于让线程阻塞（非阻塞的）
 * @date 2020/9/721:50
 */
public class SynchronizedMonitorDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }

}
