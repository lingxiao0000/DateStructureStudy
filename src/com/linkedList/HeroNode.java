package com.linkedList;

/**
 * 英雄节点
 */
public class HeroNode {
    private String name; // 英雄姓名
    private int no;  // 英雄编号
    private HeroNode next;  // 下一个节点

    public HeroNode(String name, int no) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }

    public HeroNode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
}
