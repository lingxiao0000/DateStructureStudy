package com.threadedtree;

/**
 * 线索化二叉树的实现
 *
 * @author Lingxiao
 * @date 2023/4/21 13:36
 */
public class ThreadedTree {
    private final TreeNode root;
    private TreeNode pre;  // 用来记录前驱结点

    public ThreadedTree(TreeNode root) {
        this.root = root;
    }

    /**
     * 执行线索化方法
     */
    public void ThreadedInit() {
        ThreadedInit(root);
    }

    /**
     * 执行线索化方法,这里是前序线索化
     *
     * @param node 要开始线索化的结点
     */
    public void ThreadedInit(TreeNode node) {
        if (node == null) {
            return;
        }

        // （1）父节点线索化
        // 如果前驱结点不为空且前驱结点的右结点为空，那么前驱结点的右节点指向当前结点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        // 如果左子结点为空，那么指向前驱结点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        pre = node;
        // （2）左节点线索化
        if (node.getLeftType() != 1) {
            ThreadedInit(node.getLeft());
        }
        // （3）右节点线索化
        if (node.getRightType() != 1) {
            ThreadedInit(node.getRight());

        }
    }

    /**
     * 前序遍历线索二叉树
     */
    public void preOrder() {
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }
        TreeNode node = root;
        while (node != null) {
            // 输出父节点
            System.out.println(node);
            // 输出后继结点
            // 在线索二叉树中，后继结点的优先级比规则要高（因为已经明确下一个后继节点了，就不用按照规则获取后继节点了）
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            // 如果后继结点找不到了，在根据规则获取后继结点
            // 输出左节点,根据前序规则，左节点就是后继节点了
            while(node.getLeftType() == 0) {
                node = node.getLeft();
                System.out.println(node);
            }
            // 获取右节点
            node = node.getRight();
        }
    }


}
