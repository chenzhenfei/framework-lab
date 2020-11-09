package com.tsshare.lab06;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzhenfei
 * @title: CASDemo
 * @projectName framework-lab
 * @description: CampareAndSwap  比较交换   乐观锁的概念  会出现ABA 问题，需要加上版本号可以避免这个问题 1A->2B->3A
 * @date 2020/9/723:14
 */
public class CASDemo {
    private static AtomicInteger a =new AtomicInteger(0);
    public static void main(String[] args) {
         int andIncrement = a.getAndIncrement();
        int i1 = a.incrementAndGet();

        int i = a.get();
//        int i = a.addAndGet(1);
        System.out.println( andIncrement +":" +i1);
    }

}
