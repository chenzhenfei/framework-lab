package com.tsshare.sort.insertsort;

import com.tsshare.sort.AbstractSort;
import com.tsshare.sort.choosesort.DirectChooseSort;

/**
 * @author chenzhenfei
 * @title: DirectInsertSort
 * @projectName framework-lab
 * @description: 直接插入排序
 * @date 2020/6/2221:03
 */
public class DirectInsertSort extends AbstractSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 78, 5, 6, 9, 1, 4, 3};
        DirectChooseSort directInsertSort = new DirectChooseSort();
        int[] sort = directInsertSort.sort(a);
        for (int i = 0; i <sort.length ; i++) {
            System.out.println(sort[i]);
        }


    }

    @Override
    public int[] sort(int[] a) {

        return null;
    }
}
