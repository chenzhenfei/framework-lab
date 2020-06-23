package com.tsshare.sort.choosesort;

import com.tsshare.sort.AbstractSort;

import java.util.Arrays;

/**
 * @author chenzhenfei
 * @title: HeapSort
 * @projectName framework-lab
 * @description: 堆排序
 * @date 2020/6/2323:18
 */
public class HeapSort extends AbstractSort {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 78, 5, 6, 9, 1, 4, 3};
        HeapSort directInsertSort = new HeapSort();
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
        int arrayLength = a.length;
        // 循环建堆
        for (int i = 0; i < arrayLength - 1; i++) {
            // 建堆
            buildMaxHeap(res, arrayLength - 1 - i);
            // 交换堆顶和最后一个元素
            swap(res, 0, arrayLength - 1 - i);
        }
        return res;
    }

    private void buildMaxHeap(int[] data, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // k保存正在判断的节点
            int k = i;
            // 如果当前k节点的子节点存在
            while (k * 2 + 1 <= lastIndex) {
                // k节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                // 如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
                if (biggerIndex < lastIndex) {
                    // 若果右子节点的值较大
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // biggerIndex总是记录较大子节点的索引
                        biggerIndex++;
                    }
                }
                // 如果k节点的值小于其较大的子节点的值
                if (data[k] < data[biggerIndex]) {
                    // 交换他们
                    swap(data, k, biggerIndex);
                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
