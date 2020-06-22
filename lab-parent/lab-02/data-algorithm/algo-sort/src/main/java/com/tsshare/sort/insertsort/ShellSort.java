package com.tsshare.sort.insertsort;

import com.tsshare.sort.AbstractSort;

/**
 * @author chenzhenfei
 * @title: ShellSort
 * @projectName framework-lab
 * @description: 希尔排序 = 直接插入排序的变种， 通过分组方式去实现 ，循环嵌套较多
 * @date 2020/6/2223:35
 */
public class ShellSort  extends AbstractSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 78, 5, 6, 9, 1, 4, 3};
        ShellSort directInsertSort = new ShellSort();
        int[] sort = directInsertSort.sort(a);
        for (int i = 0; i <sort.length ; i++) {
            System.out.println(sort[i]);
        }
    }

    @Override
    public int[] sort(int[] a) {
        int d = a.length;
        while (true)
        {
            d = d / 2;
            for (int x = 0; x < d; x++)
            {
                for (int i = x + d; i < a.length; i = i + d)
                {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d)
                    {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1)
            {
                break;
            }
        }
        return a;
    }
}
