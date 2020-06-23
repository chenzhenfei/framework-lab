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
        if (a == null || a.length == 0) {
            return null;
        }
        int[] res = a;

        for (int i = 1; i < res.length; i++) {
            int tmp = res[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                boolean b = res[j] > tmp;
                if (b) {
                    res[j + 1] = res[j];
                } else {
                    break;
                }
            }
            res[j + 1] = tmp;
        }
        return res;
    }
}
