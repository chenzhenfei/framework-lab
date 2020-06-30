package com.tsshare.bitset;

import java.util.BitSet;

/**
 * @author chenzhenfei
 * @title: BitMap
 * @projectName framework-lab
 * @description: TODO
 * @date 2020/6/3023:52
 */
public class BitMap {
    public static final int _1MB = 1024 * 1024;
    //每个byte记录8bit信息,也就是8个数是否存在于数组中
    public static byte[] flags = new byte[512 * _1MB];

    public void setFlagSelf(int num) {
        //使用每个数的低三位作为byte内的映射
        //例如: 255 = (11111111)
        //低三位(也就是num & (0x07))为(111) = 7, 则byte的第7位为1, 表示255已存在
        flags[num >> 3] |= 0x01 << (num & (0x07));
    }

    public boolean getFlagSelf(int num) {
        return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
    }

    /***************下面是bitset ************/

    static BitSet seen = new BitSet((1 << 31) - 1);

    public void setFlag(int num) {
        seen.set(num);
    }

    public boolean getFlag(int num) {
        return seen.get(num);
    }

    public void add(String value) {
        // 定义一个hash 函数
        int hashint = Math.abs(value.hashCode());
        setFlag(hashint);
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        // 定义一个hash 函数
        int hashint = Math.abs(value.hashCode());
        return getFlag(hashint);
    }

}
