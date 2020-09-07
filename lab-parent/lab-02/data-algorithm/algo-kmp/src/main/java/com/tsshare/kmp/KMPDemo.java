package com.tsshare.kmp;

/**
 * @author chenzhenfei
 * @title: KMPDemo
 * @projectName framework-lab
 * @description:
 * @date 2020/7/10:11
 */
public class KMPDemo {

    public static void main(String[] args) {
        String tmp ="BBC ABCDAB ABCDABCDABDE";
        boolean ab = tmp.contains("ABCDABD");
        System.out.println(ab);
    }
}
