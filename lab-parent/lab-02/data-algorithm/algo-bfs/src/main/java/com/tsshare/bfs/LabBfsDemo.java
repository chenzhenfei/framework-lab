package com.tsshare.bfs;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author : zfchen
 * @version 1.0
 * @Description: 二叉树每行最值           https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * @date : 2020-07-09 8:53
 * <p>
 * 1
 * 3    2
 * 5  3  2  3
 * <p>
 * 解析： 遍历树节点只是采用队列方式，怎么处理队列中的值属于同一行： 我们按照每一行入列之后全部处理之后，再入列下一行
 */
public class LabBfsDemo {


    public static void main(String[] args) {
        LabBfsDemo labBfsDemo = new LabBfsDemo();
        BinTreeNode root = new BinTreeNode(1, null, null);
        BinTreeNode seconeL = new BinTreeNode(10, null, null);
        BinTreeNode seconeR = new BinTreeNode(5, null, null);

        seconeL.setLeft(new BinTreeNode(8, null, null));
        seconeL.setRight(new BinTreeNode(3, null, null));
        seconeR.setLeft(new BinTreeNode(2, null, null));
        seconeR.setRight(new BinTreeNode(20, null, null));
        root.setLeft(seconeL);
        root.setRight(seconeR);
        List<Integer> res = labBfsDemo.find(root);
        res.stream().forEach(System.out::println);

        Integer integer = res.stream().map((a) -> {
            return a;
        }).reduce(Integer::max).orElse(0);
        System.out.println(integer);
    }

    private List<Integer> find(BinTreeNode treeNode) {
        List<Integer> res = new ArrayList<>();
        Queue<BinTreeNode> queue = new ArrayDeque<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            // 本次需要出队列处理的个数
            int size = queue.size();
            // 获取头结点的值作为此次比较的基础值
            int max = queue.peek().getVal();
            for (int i = 0; i < size; i++) {
                BinTreeNode poll = queue.poll();
                // 本次比较结果和下一行队列入列
                if (poll != null) {
                    if (poll.getVal() > max) {
                        max = poll.getVal();
                    } else {
                        if (poll.getLeft() != null) {
                            queue.offer(poll.getLeft());
                        }
                        if (poll.getRight() != null) {
                            queue.offer(poll.getRight());
                        }
                    }
                }

            }
            res.add(max);
        }
        return res;
    }


}
