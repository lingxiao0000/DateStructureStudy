package com.threadedtree;

/**
 * 线索化二叉树的结点
 *
 * @author Lingxiao
 * @date 2023/4/21 13:38
 */
public class TreeNode {
    private Integer id;
    private String name;
    private TreeNode left;  // 左子结点
    private TreeNode right;  // 右子结点

    /**
     * 结点类型：0表示普通结点 1表示前驱或者后继结点
     */
    // 这里需要注意，如果使用Integer封装类，TreeNode默认初始化后Integer对象为空
    private int leftType;  // 左子结点类型
    private int rightType;  //  右子结点类型

    public TreeNode(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getLeftType() {
        return leftType;
    }

    public void setLeftType(Integer leftType) {
        this.leftType = leftType;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
