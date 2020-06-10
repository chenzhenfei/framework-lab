package com.tsshare.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 队列
 * @date : 2020-06-09 11:08
 */
public class QueueLab {
    public static void main(String[] args) {
        testLinkedBlockingQueue();
        testArrayBlockingQueue();
        testPriorityBlockingQueue();
        testLinkedList();
        testConcurrentLinkedQueue();
        rest:
        while(true){
            continue rest;
        }

    }

    private static void testConcurrentLinkedQueue() {
        // 非阻塞线程安全队列
        Queue u = new ConcurrentLinkedDeque();
        u.offer(1);
    }


    private static void testLinkedList() {
        // 线程不安全
        LinkedList linkedList =new LinkedList();
        linkedList.add(1);
        linkedList.add(2);

    }

    private static void testArrayBlockingQueue() {
        // 需要公平性，如果公平参数被设置true
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10, true);
//        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);
        for (int i = 0; i < 10; i++) {
            arrayBlockingQueue.offer(i);
        }
        new Thread(new Runnable() {
            int i = 10;

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        i = i + 1;
                        arrayBlockingQueue.put(i);
                        Thread.sleep(3000);
                        System.out.println(Thread.currentThread().getName() + " 尾部往里面放：" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            int i = 100;

            @Override
            public void run() {
                while (true) {
                    try {
                        arrayBlockingQueue.put(i++);
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " 尾部往里面放：" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        Object take = arrayBlockingQueue.take();
                        System.out.println(Thread.currentThread().getName() + " 从头不取：" + take);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    private static void testPriorityBlockingQueue() {
        PriorityBlockingQueue arrayBlockingQueue = new PriorityBlockingQueue(10);
        arrayBlockingQueue.offer(1);
    }


    private static void testLinkedBlockingQueue() {
        LinkedBlockingQueue q = new LinkedBlockingQueue(10);

        for (int i = 0; i < 10; i++) {
            q.offer(i);
        }
        printlnRet(q);
        new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                Object s = new Object();
                synchronized (s) {
                    while (i < 10) {
                        try {
                            Thread.sleep(1000);
                            i++;
                            q.put(i);
                            System.out.println("尾部往里面放：" + i);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10000);
                        Object poll = q.take();
                        System.out.println("头部往取：" + poll);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public static void printlnRet(LinkedBlockingQueue q) {
        Iterator iterator = q.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


}
