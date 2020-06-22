package com.tsshare.sort.choosesort;

import com.tsshare.sort.AbstractSort;
import com.tsshare.sort.insertsort.DirectInsertSort;

/**
 * @author chenzhenfei
 * @title: DirectChooseSort
 * @projectName framework-lab
 * @description: TODO
 * @date 2020/6/2223:52
 */
public class DirectChooseSort extends AbstractSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 78, 5, 6, 9, 1, 4, 3};
        DirectInsertSort directInsertSort = new DirectInsertSort();
        int[] sort = directInsertSort.sort(a);
        for (int i = 0; i <sort.length ; i++) {
            System.out.println(sort[i]);
        }
    }

    @Override
    public int[] sort(int[] a) {

        return new int[0];
    }
}
