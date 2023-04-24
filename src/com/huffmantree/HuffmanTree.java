package com.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树的实现
 *
 * @author Lingxiao
 * @date 2023/4/21 17:10
 */
public class HuffmanTree {
    private HuffmanNode root;  // 根节点

    public HuffmanTree() {
    }

    /**
     * 创建赫夫曼树
     *
     * @param arr
     */
    public void create(int[] arr) {
        // 首先将数据中的数据放入集合当中，方便排序
        List<HuffmanNode> list = new ArrayList<>();
        for (int i : arr) {
            list.add(new HuffmanNode(i));
        }
        // 通过循环创建赫夫曼树
        while (list.size() > 1) {
            // （1）对集合进行排序
            Collections.sort(list);
            // （2）将最小的两个结点拿出，构成一个二叉树
            HuffmanNode leftNode = list.get(0);
            HuffmanNode rightNode = list.get(1);
            HuffmanNode newNode = new HuffmanNode(leftNode.getId() + rightNode.getId());
            newNode.setLeft(leftNode);
            newNode.setRight(rightNode);
            // （3）将集合中的两个二叉树移除，加入新的二叉树
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(newNode);
        }
        this.root = list.get(0); // 获取创建完成的赫夫曼树
    }

    public void preOrder() {
        preOrder(root);
    }

    /**
     * 进行前序遍历
     */
    public void preOrder(HuffmanNode node) {
        if (node != null) {
            // 父节点输出
            System.out.println(node.getId());
            if (node.getLeft() != null) {
                preOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                preOrder(node.getRight());
            }
        }
    }
}
