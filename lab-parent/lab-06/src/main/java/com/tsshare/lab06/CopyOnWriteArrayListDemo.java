package com.tsshare.lab06;

import sun.awt.windows.ThemeReader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/**
 * @author chenzhenfei
 * @title: CopyOnWriteArrayListDemo
 * @projectName framework-lab
 * @description: 复制写容器  在读数据允许延时的情况下，可以采用copyOnWriteArray
 *               add 采用了volatile 对数组引用做了线程的可见性，
 *               如果是普通 arrayList,他的工作内存中的list的引用是没有发生变化的，但是内存已经发生了变化
 *
 * @date 2020/9/1422:22
 */
public class CopyOnWriteArrayListDemo  {

    public static void main(String[] args) {
//        CopyOnWriteArrayList<Integer> integerCopyOnWriteArrayList =new CopyOnWriteArrayList<>();
        ArrayList integerCopyOnWriteArrayList = new ArrayList();
        new Thread(new ReadThread(integerCopyOnWriteArrayList)).start();
        new Thread(new WriteThread(integerCopyOnWriteArrayList)).start();
    }
    static class ReadThread implements Runnable{
        private List list;

        public ReadThread(List list) {
            this.list = list;
        }
        @Override
        public void run() {
//            while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < list.size(); i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("总条数：" + list.size() + ",当前第：" + list.get(i) + "条");
                }
//            }
        }
    }

    static class WriteThread implements  Runnable{
        private List list;

        public WriteThread(List list) {
            this.list = list;
        }
        @Override
        public void run() {
            for (int i = 0; i <5 ; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.add(100+i);
                System.out.println("写入第："+list.size());

            }
        }
    }


}
