package com.tsshare.lab06;

/**
 * @author chenzhenfei
 * @title: ThreadExceptionDemo
 * @projectName framework-lab
 * @description: 一个线程如果出现了运行时异常会怎么样
 * @date 2020/9/1320:20
 */
public class ThreadExceptionDemo extends Thread{
    private String objectLock ="test";

    private void synFun1(){
        synchronized (objectLock){
            System.out.println(Thread.currentThread().getName()+"：已经获得同步锁");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i =1/0;
        }
    }

    private void synFun2(){
        synchronized (objectLock){
            System.out.println(Thread.currentThread().getName()+"：已经获得同步锁");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        synchronized (objectLock){
            System.out.println(Thread.currentThread().getName()+"：已经获得同步锁");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i =1/0;
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        new ThreadExceptionDemo().start();
        new ThreadExceptionDemo().start();
    }

    private static void test1() {
        ThreadExceptionDemo threadExceptionDemo = new ThreadExceptionDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExceptionDemo.synFun1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExceptionDemo.synFun2();
            }
        }).start();
    }


}
