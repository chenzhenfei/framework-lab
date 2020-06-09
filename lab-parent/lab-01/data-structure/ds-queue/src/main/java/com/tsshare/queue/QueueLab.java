package com.tsshare.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 队列
 * @date : 2020-06-09 11:08
 */
public class QueueLab {
    public static void main(String[] args) {
        Queue<String> que =new LinkedBlockingQueue<String>();
        que.offer("1");
        que.offer("2");
        que.offer("3");
        que.offer("4");

        while (!que.isEmpty()){
            System.out.println(que.poll());
        }

        testLinkedList();
    }

    private static void testLinkedList() {
        Queue q= new LinkedList();
        LinkedList linkedList = new LinkedList();
    }

}
