package com.tsshare.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author chenzhenfei
 * @title: TreeNode
 * @projectName framework-lab
 * @description: 树节点，作为存储数据的单元
 * @date 2020/6/1722:00
 */
public class TreeNode<T> implements Comparable {
    public TreeNode() {
    }

    public TreeNode(int index, T data, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        this.index = index;
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    private int index;
    //当前数据
    private T data;
    //左节点
    private TreeNode<T> leftNode;
    //右节点
    private TreeNode<T> rightNode;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }


    @Override
    public int compareTo(Object o) {
        TreeNode o1 = (TreeNode) o;
        return this.index-o1.index;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "index=" + index +
                ", data=" + data +
                '}';
    }
}
