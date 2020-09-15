package com.tsshare.lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenzhenfei
 * @title: ProductorConsumerDemo
 * @projectName framework-lab
 * @description: 生产者/消费者 使用syn实现   生产者/消费着案例
 *                  1、notify 早期通知
 *                  2、假死
 * @date 2020/9/1322:33
 */
public class ProductorConsumerDemoSyn {


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Productor(integers, 8));
        }
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Consumer(integers));
        }
    }


    static class Productor implements Runnable {
        private List<Integer> list;
        private int length;

        public Productor(List<Integer> list, int length) {
            this.list = list;
            this.length = length;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    try {
                        while (list.size() == length) {
                            boolean b = Thread.holdsLock(list);
                            System.out.println(b);
                            System.out.println(Thread.currentThread().getName() + "：生产者已经达到峰值");
                            list.wait();
                            System.out.println(Thread.currentThread().getName() + "：退出wait");
                        }
                        Random random = new Random();
                        list.add(random.nextInt());
                        // 唤醒其他线程
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private List<Integer> list;

        public Consumer(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    try {
                        while (list.size() == 0) {
                            System.out.println(Thread.currentThread().getName() + "：消费者已经为0");
                            list.wait();
                            System.out.println(Thread.currentThread().getName() + "：退出wait");
                        }
                        Integer remove = list.remove(0);
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }


}
