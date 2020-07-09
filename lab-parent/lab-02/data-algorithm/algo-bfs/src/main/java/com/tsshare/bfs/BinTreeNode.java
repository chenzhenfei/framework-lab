package com.tsshare.bfs;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 二叉树节点
 * @date : 2020-07-09 9:06
 */
public class BinTreeNode {
        private Integer val;
        private BinTreeNode left;
        private BinTreeNode right;

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public BinTreeNode(Integer val, BinTreeNode left, BinTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    public BinTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinTreeNode left) {
        this.left = left;
    }

    public BinTreeNode getRight() {
        return right;
    }

    public void setRight(BinTreeNode right) {
        this.right = right;
    }
}
