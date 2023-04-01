package com.ringLinkedList;

/**
 * 学生节点
 */
public class StudentNode {
    private String name;
    private Integer no;
    private StudentNode next;

    public StudentNode(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    public StudentNode() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StudentNode{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}
