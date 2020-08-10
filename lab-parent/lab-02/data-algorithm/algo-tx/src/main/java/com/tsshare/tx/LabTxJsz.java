package com.tsshare.tx;

/**
 * @author chenzhenfei
 * @title: LabTx
 * @projectName framework-lab
 * @description: 贪心demo1 - 剪绳子 https://www.cnblogs.com/MrSaver/p/8641971.html
 * @date 2020/8/1023:43
 */
public class LabTxJsz {
    public static void main(String[] args) {
        int n = 5;
        int i = greedy_cut_rope_ddf(n);
        System.out.println(i);
        int i1 = greedy_cut_rope_dgf(n);
        System.out.println(i1);
    }

    /**
     * 递归法
     *
     * @param n
     */
    private static int greedy_cut_rope_dgf(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        //尽可能多地去减长度为3的绳子段
        int timesOf3 = n / 3;
        //当绳子最后剩下的长度为4的时候，不能再去剪去长度为3的绳子段
        while (n - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    /**
     * 迭代法
     *
     * @param n
     */
    private static int greedy_cut_rope_ddf(int n) {
        if(n==2) {
            return 2;
        }
        if(n==3) {
            return 3;
        }
        if(n<2) {
            return 1;
        }
        //int timesOf3 = n/3;
        if(n==4) {
            return 4;
        }
        return 3*greedy_cut_rope_dgf(n-3);
    }
}
