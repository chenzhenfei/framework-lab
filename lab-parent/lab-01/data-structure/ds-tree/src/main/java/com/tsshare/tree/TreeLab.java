package com.tsshare.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chenzhenfei
 * @title: TreeLab
 * @projectName framework-lab
 * @description:
 * @date 2020/6/1721:59
 */
public class TreeLab {
    public static void main(String[] args) {
        BitTree<Integer> bit = new BitTree<Integer>();
        for (int i = 5; i < 10; i++) {
            TreeNode<Integer> t = new TreeNode<>();
            t.setIndex(i);
            t.setData(i);
            bit.add(t);
        }
        for (int i = 1; i < 5; i++) {
            TreeNode<Integer> t = new TreeNode<>();
            t.setIndex(i);
            t.setData(i);
            bit.add(t);
        }
        bit.forEach(System.out::println);

    }
}
