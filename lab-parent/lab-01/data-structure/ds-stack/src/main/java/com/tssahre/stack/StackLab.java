package com.tssahre.stack;

import jdk.nashorn.internal.ir.Node;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: TODO
 * @date : 2020-06-16 8:46
 */
public class StackLab {
    public static void main(String[] args) {
//        testSeqStack();
        testLinkedStack();
    }

    private static void testLinkedStack() {
        LinkedStack<Integer> ls = new LinkedStack<>();
        for (int i = 0; i < 1000; i++) {
            ls.push(i);
        }
        System.out.println(ls.peek());
        System.out.println(ls.size());
        for (int i = 0; i < 1000; i++) {
            System.out.println(ls.pop());
        }
        System.out.println(ls.size());
    }

    private static void testSeqStack() {
        SeqStack<Integer> ss = new SeqStack<>(5);
        for (int i = 0; i < 10; i++) {
            ss.push(i);
        }
        System.out.println(ss.size());
        for (int i = 0; i < 10; i++) {
            Integer pop = ss.pop();
            System.out.println(pop);
        }
        System.out.println(ss.size());
    }
}
