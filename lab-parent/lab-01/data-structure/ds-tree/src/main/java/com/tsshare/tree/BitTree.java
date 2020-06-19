package com.tsshare.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author chenzhenfei
 * @title: BitTree
 * @projectName framework-lab
 * @description: 二叉树结构
 * @date 2020/6/1722:15
 */
public class BitTree<T> {
    private int size;

    /***
     * @Description:根节点
     * @Author: zfchen
     * @Date: 2020/6/19 14:09
     **/
    private TreeNode<T> root;

    public boolean add(TreeNode<T> t) {
        TreeNode<T> objectTreeNode = t;
        if (root == null) {
            root = objectTreeNode;
        } else {
            // 找到合适的点
            TreeNode<T> findNode = root;
            while (true) {
                if (findNode.compareTo(objectTreeNode) > 0) {
                    TreeNode<T> leftNode = findNode.getLeftNode();
                    if (leftNode == null) {
                        findNode.setLeftNode(objectTreeNode);
                        break;
                    } else {
                        findNode = leftNode;
                    }
                } else {
                    TreeNode<T> rightNode = findNode.getRightNode();
                    if (rightNode == null) {
                        findNode.setRightNode(objectTreeNode);
                        break;
                    } else {
                        findNode = rightNode;
                    }
                }
            }
        }
        size++;
        return true;
    }


    /***
     * @Description:遍历 ,可选择便利方式
     * @Author: zfchen
     * @Date: 2020/6/19 9:39
     **/
    public void forEach(Consumer<? super T> action) {
        // 用于遍历临时存储
        List<T> list ;
        Objects.requireNonNull(action);
//        list=  preOrder(root);
//        list =inOrder(root);
        list =backOrder(root);
        for (int i = 0; i <list.size() ; i++) {
            action.accept(list.get(i));
        }

    }

    /**
     * 前序遍历  中左右
     * @param root
     * @return
     */

    private List<T> preOrder(TreeNode<T> root) {
        List<T> list = new ArrayList<>();
        if(root!=null){
            list.add(root.getData());
            preOrder(root.getLeftNode());
            preOrder(root.getRightNode());
        }
        return list;
    }

    /**
     * 中序遍历 左中右
     * @param root
     * @return
     */
    private List<T> inOrder(TreeNode<T> root) {
        List<T> list = new ArrayList<>();
        if(root!=null){
            inOrder(root.getLeftNode());
            list.add(root.getData());
            inOrder(root.getRightNode());
        }
        return list;
    }

    /**
     * 后序遍历 左右中
     * @param root
     * @return
     */
    private List<T> backOrder(TreeNode<T> root) {
        List<T> list = new ArrayList<>();
        if(root!=null){
            backOrder(root.getLeftNode());
            backOrder(root.getRightNode());
            list.add(root.getData());
        }
        return list;
    }



    public int size(){
        return this.size;
    }
    public Boolean isEmpty(){
        return this.size == 0;
    }
}
