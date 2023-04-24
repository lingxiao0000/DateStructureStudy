package com.huffmantree;

/**
 * 赫夫曼树结点
 * @author Lingxiao
 * @date 2023/4/21 17:12
 */
public class HuffmanNode implements Comparable<HuffmanNode>{
    private Integer id;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        // 从小到大排序
        return this.id - o.getId();
    }
}
