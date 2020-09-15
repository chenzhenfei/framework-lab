package com.tsshare.lab06;

import java.util.concurrent.*;

/**
 * @author chenzhenfei
 * @title: FutureTaskDemo
 * @projectName framework-lab
 * @description: 异步运算任务
 * @date 2020/9/1523:49
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        testFutureTask();
    }

    private static void testFutureTask() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new TaskCallAble());
        executorService.submit(new TaskCallAble());
        Future<?> submit = executorService.submit(new TaskCallAble());
        Object o = null;
        try {
            o= submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o.toString());
    }

    static class TaskCallAble implements Runnable {
        private int a = 0;
//        @Override
//        public Object call() throws Exception {
//            for (int i = 0; i < 10; i++) {
//                a = a + i;
//            }
//            System.out.println(a);
//            return a;
//        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                a = a + i;
            }
            System.out.println(a);
        }
    }
}
