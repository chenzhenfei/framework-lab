package com.tsshare.lab06;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenzhenfei
 * @title: ProductComsumerBlockingQueue
 * @projectName framework-lab
 * @description: 使用组赛队列实现 生产者/消费者
 * @date 2020/9/1323:19
 */
public class ProductComsumerBlockingQueue {
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Productor(queue));
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(queue));
        }
    }


    static class Productor implements Runnable{
        private BlockingQueue<Integer> lock;

        public Productor(BlockingQueue<Integer> lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true){
                Random random =new Random();
                try {
                    System.out.println(Thread.currentThread().getName()+"：生产数据" +lock.size());
                    lock.put(random.nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{
        private BlockingQueue<Integer> lock;

        public Consumer(BlockingQueue<Integer> lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true){
                try {
                    System.out.println(Thread.currentThread().getName()+"：消费线程"+lock.size());
                    lock.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
