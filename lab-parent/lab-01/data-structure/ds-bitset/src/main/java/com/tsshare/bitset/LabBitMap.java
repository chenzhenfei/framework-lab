package com.tsshare.bitset;

import java.util.BitSet;

/**
 * @author chenzhenfei
 * @title: LabBitMap
 * @projectName framework-lab
 * @description: BitMap
 * @date 2020/6/2823:43
 */
public class LabBitMap {


    public static void main(String[] args) {
        //待判重数据
        int[] array = {65535, 2, 3, 4, 5};

        BitMap labBitMap = new BitMap();
        int index = 0;
        for (int num : array) {
            if (!labBitMap.getFlag(num)) {
                //未出现的元素
                array[index] = num;
                index = index + 1;
                //设置标志位
                labBitMap.setFlag(num);
                System.out.println("set " + num);
            } else {
                System.out.println(num + " already exist");
            }
        }
    }


}
