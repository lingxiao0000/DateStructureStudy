package com.threadedtree;

/**
 * 线索二叉树测试
 */
public class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,"张三");
        TreeNode node1 = new TreeNode(2,"李四");
        TreeNode node2 = new TreeNode(3, "王五");
        TreeNode node3 = new TreeNode(4, "老六");
        TreeNode node4 = new TreeNode(5, "陈七");
        TreeNode node5 = new TreeNode(6, "老八");
        TreeNode node6 = new TreeNode(7, "许九");
        TreeNode node7 = new TreeNode(8, "陈十");

        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        node2.setRight(node6);
        node3.setLeft(node7);

        ThreadedTree threadedTree = new ThreadedTree(root);
        threadedTree.ThreadedInit();

        threadedTree.preOrder();

    }
}
