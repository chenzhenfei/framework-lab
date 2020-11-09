package com.tsshare.lab13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzhenfei
 * @title: Lab13
 * @projectName framework-lab
 * @description: 两个链表的交集
 * @date 2020/11/922:58
 */
public class Lab13Demo2 {

    public static void main(String[] args) {
       List list =new LinkedList();
       List list1 =new LinkedList();

        for (int i = 0; i <10 ; i++) {
            list.add(i);
            list1.add(i+2);
        }
        list.retainAll(list1);
        list.stream().forEach(System.out::println);

    }



}
