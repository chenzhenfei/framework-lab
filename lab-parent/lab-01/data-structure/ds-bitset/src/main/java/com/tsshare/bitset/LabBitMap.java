package com.tsshare.bitset;

import java.util.BitSet;

/**
 * @author chenzhenfei
 * @title: LabBitMap
 * @projectName framework-lab
 * @description: TODO
 * @date 2020/6/2823:43
 */
public class LabBitMap {
    public static final int _1MB = 1024 * 1024;
    //每个byte记录8bit信息,也就是8个数是否存在于数组中
    public static byte[] flags = new byte[ 512 * _1MB ];


    public static void main(String[] args) {
        //待判重数据
        int[] array = {65535, 2, 3, 4, 5};

        int index = 0;
        for(int num : array) {
            if(!getFlag(num)) {
                //未出现的元素
                array[index] = num;
                index = index + 1;
                //设置标志位
                setFlag(num);
                System.out.println("set " + num);
            } else {
                System.out.println(num + " already exist");
            }
        }
    }
//
//    public static void setFlag(int num) {
//        //使用每个数的低三位作为byte内的映射
//        //例如: 255 = (11111111)
//        //低三位(也就是num & (0x07))为(111) = 7, 则byte的第7位为1, 表示255已存在
//        flags[num >> 3] |= 0x01 << (num & (0x07));
//
//    }
//    public static boolean getFlag(int num) {
//        return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
//    }

    static BitSet seen = new BitSet((1 << 31) - 1);
    public static void setFlag(int num) {
        seen.set(num);
    }
    public static boolean getFlag(int num) {
        return seen.get(num);
    }
}
