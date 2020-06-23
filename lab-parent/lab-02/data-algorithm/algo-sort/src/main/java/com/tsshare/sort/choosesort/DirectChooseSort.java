package com.tsshare.sort.choosesort;

import com.tsshare.sort.AbstractSort;
import com.tsshare.sort.insertsort.DirectInsertSort;

/**
 * @author chenzhenfei
 * @title: DirectChooseSort
 * @projectName framework-lab
 * @description: 选择排序 - 直接选择排序
 * @date 2020/6/2223:52
 */
public class DirectChooseSort extends AbstractSort {
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
        if (a == null || a.length == 0) {
            return null;
        }
        int[] res = a;
        for (int i = 0; i < res.length - 1; i++) {
            int tmp = res[i];
            int min = res[i + 1];
            int index = i + 1;
            for (int j = i + 1; j < res.length; j++) {
                if (res[j] <= min) {
                    min = res[j];
                    index = j;
                }
            }
            if (tmp > min) {
                res[index] = res[i];
                res[i] = min;
            }
        }
        return res;
    }
}
