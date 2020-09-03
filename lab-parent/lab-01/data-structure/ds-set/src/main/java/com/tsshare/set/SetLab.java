package com.tsshare.set;

import java.util.*;

/**
 * @author chenzhenfei
 * @title: SetLab
 * @projectName framework-lab
 * @description: set
 * @date 2020/6/110:47
 */
public class SetLab {

    public static void main(String[] args) {
        // 存取不重复的集合  重复条件： hashcode 相同 && equals 相同
       testHashSet();
        //会保存插入的顺序
        testLinkedHashSet();
        // 有序不重复   判断重复的条件： 排序结果==0 相等
         testTreeSet();
        Object o =new Object();
        o.hashCode();

    }

    private static void testLinkedHashSet() {
        Set<LabDemo> set =new LinkedHashSet<>();
        setData(set);
        printOut(set);
    }

    /**
     * 给TreeSet指定排序规则方式：
     * 1、对象实现Comparable 自然排序接口
     * 2、沟通一个Comparator 实现类比较器 传入 TreeSet 构造一个有比较器的TreeSet
     */
    private static void testTreeSet() {
        Set<LabDemo> set =new TreeSet<LabDemo>(new Comparator<LabDemo>() {
            @Override
            public int compare(LabDemo o1, LabDemo o2) {
                return 0;
            }
        });
        setData(set);
        printOut(set);
    }

    private static void setData(Set<LabDemo> set) {
        LabDemo ld1 =new LabDemo(1,"1");
        LabDemo ld2 =new LabDemo(1,"1");
        LabDemo ld4 =new LabDemo(4,"4");
        LabDemo ld3 =new LabDemo(3,"3");
        LabDemo ld31 =new LabDemo(3,"3");
        boolean hascode =ld1.hashCode() == ld2.hashCode();
        boolean equals = ld1.equals(ld2);

        set.add(ld1);
        set.add(ld2);
        set.add(ld4);
        set.add(ld3);
        set.add(ld31);

    }

    private static void testHashSet() {
        Set<LabDemo> set =new HashSet<>();
        setData(set);
        printOut(set);
    }

    private static void printOut(Set<LabDemo> set) {
        set.forEach((a)->{
            System.out.println(a);
        });
    }

}
