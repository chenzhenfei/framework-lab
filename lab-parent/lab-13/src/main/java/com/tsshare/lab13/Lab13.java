package com.tsshare.lab13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzhenfei
 * @title: Lab13
 * @projectName framework-lab
 * @description: 两个集合的交集
 * @date 2020/11/922:58
 */
public class Lab13 {

    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        List<String> list1 =new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add("@@"+i);
            list1.add("@@"+(i+9));
        }
        testBj(list,list1);

    }

    private static void testBj(List<String> list, List<String> list1) {

        boolean b = list.removeAll(list1);
        boolean b1 = list.addAll(list1);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void testJj(List<String> list, List<String> list1) {
        boolean b = list.retainAll(list1);
        System.out.println(b);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}
