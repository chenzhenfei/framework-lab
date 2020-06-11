package com.tsshare.queue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 队列
 * @date : 2020-06-09 11:08
 */
public class DequeLab {
    public static void main(String[] args) {
        testLinkedBlockingQqueue();
        
    }

    private static void testLinkedBlockingQqueue() {
        LinkedBlockingDeque q =new LinkedBlockingDeque();
        q.offer(1);
    }


}
