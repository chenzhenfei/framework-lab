package com.tsshare.sort.insertsort;

import com.tsshare.sort.AbstractSort;

/**
 * @author chenzhenfei
 * @title: BisDirectInsertSort
 * @projectName framework-lab
 * @description: 二分法插入排序   逐个将当前位置的值如果插到 前面的合适位置上
 * @date 2020/6/2221:59
 */
public class BisDirectInsertSort extends AbstractSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 78, 5, 6, 9, 1, 4, 3};
        BisDirectInsertSort directInsertSort = new BisDirectInsertSort();
        int[] sort = directInsertSort.sort(a);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

    @Override
    public int[] sort(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int[] res = a;
        for (int i = 1; i < a.length; i++) {
            int tmp = res[i];
            int left = 0, right = i - 1, mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (res[mid] > tmp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                res[j + 1] = res[j];
            }
            if (left != i) {
                res[left] = tmp;
            }
        }
        return res;
    }

}
