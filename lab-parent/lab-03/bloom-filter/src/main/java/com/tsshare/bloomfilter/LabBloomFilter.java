package com.tsshare.bloomfilter;

import com.tsshare.bitset.BitMap;
import com.tsshare.bitset.LabBitMap;

/**
 * @author chenzhenfei
 * @title: LabBloomFilter
 * @projectName framework-lab
 * @description: URL 去重
 * @date 2020/6/3022:48
 */
public class LabBloomFilter {
    private final String[] URLS = {
            "http://www.csdn.net/",
            "http://www.baidu.com/",
            "http://www.google.com.hk",
            "http://www.cnblogs.com/",
            "http://www.zhihu.com/",
            "https://www.shiyanlou.com/",
            "http://www.google.com.hk",
            "https://www.shiyanlou.com/",
            "http://www.csdn.net/"};

    public static void main(String[] args) {
        LabBloomFilter lbf = new LabBloomFilter();
        lbf.testBloomFilter();
        lbf.testBitMap();
    }

    private void testBitMap() {
        // 自定义BitMap 过滤器
        BitMap lbm = new BitMap();
        for (int i = 0; i < URLS.length; i++) {
            //简单hash一下 Math.abs(URLS[i].hashCode()
            if (lbm.contains(URLS[i])) {
                System.out.println("BitMap ==> contain: " + URLS[i]);
                continue;
            }
            lbm.add(URLS[i]);
        }
    }

    private void testBloomFilter() {
        // 自定义布隆过滤器
        BloomFilter filter = new BloomFilter();
        for (int i = 0; i < URLS.length; i++) {
            if (filter.contains(URLS[i])) {
                System.out.println("BloomFilter ==> contain: " + URLS[i]);
                continue;
            }
            filter.add(URLS[i]);
        }
    }

}
