package com.tsshare.lab04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: CAS 原子操作
 * @date : 2020-09-03 8:48
 */
public class CasLab {

    private static AtomicInteger atomicInteger =new AtomicInteger();
    private static int k =0;
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        CasLab casLab = new CasLab();
        Runnable runnable =new myRunnable();
        Runnable runnable2 =new myRunnable();
        executorService.submit(runnable);
        executorService.submit(runnable2);

    }

    static class myRunnable implements Runnable{
        int j=0;
        @Override
        public void run() {
            for (int i = 0; i <100 ; i++) {
                j = atomicInteger.addAndGet(1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                k++;
                System.out.println(j+" :: "+ k );
            }
        }

    }

}
