package com.tsshare.bloomfilter;

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
    }

    private void testBloomFilter() {
        BloomFilter filter = new BloomFilter();
        for (int i = 0; i < URLS.length; i++) {
            if (filter.contains(URLS[i])) {
                System.out.println("contain: " + URLS[i]);
                continue;
            }
            filter.add(URLS[i]);
        }
    }

}
