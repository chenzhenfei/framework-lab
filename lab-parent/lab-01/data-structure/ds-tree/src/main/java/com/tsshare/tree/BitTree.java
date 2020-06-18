package com.tsshare.tree;

/**
 * @author chenzhenfei
 * @title: BitTree
 * @projectName framework-lab
 * @description: 二叉树结构
 * @date 2020/6/1722:15
 */
public class BitTree<T> {
    private TreeNode<T> root;

    public boolean add(TreeNode<T> t){
        TreeNode<T> objectTreeNode =t;
        if(root ==null){
            root = objectTreeNode;
        }else{
           // 找到合适的点
            TreeNode findNode =root;
            while(true){
                if(findNode.compareTo(objectTreeNode)<0){
                    TreeNode leftNode = findNode.getLeftNode();
                    if(leftNode == null){
                        findNode.setLeftNode(leftNode);
                        break;
                    }else{
                        findNode =  leftNode;
                    }
                }else{
                    TreeNode rightNode = findNode.getRightNode();
                    if(rightNode == null){
                        findNode.setRightNode(rightNode);
                        break;
                    }else{
                        findNode =  rightNode;
                    }
                }
            }
        }
        return true;
    }


}
