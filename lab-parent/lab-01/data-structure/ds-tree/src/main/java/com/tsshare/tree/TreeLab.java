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
       BitTree<Integer> bit =new BitTree<Integer>();
        for (int i = 0; i <10 ; i++) {
            TreeNode<Integer> t =new TreeNode<>();
            t.setIndex(i);
            t.setData(i);
            bit.add(t);
        }
    }
}
