package com.ringLinkedList;

/**
 * 环形链表
 */
public class RingLinkedList {
    private StudentNode first;  // first节点，指向环形链表的第一个节点
    private StudentNode current;  // 当前节点
    private int num; // 节点数目

    public RingLinkedList(StudentNode studentNode) {
        this.first = studentNode;
        studentNode.setNext(studentNode);  // 初始化的时候也要形成环形
        this.current = studentNode;  // 初始化的时候当前节点指向第一个节点
        this.num = 1;  // 初始化后节点数为1
    }

    // 添加节点的操作
    public void add(StudentNode studentNode) {
        StudentNode node = first; // 辅助节点
        while(true) {
            // 如果下一个节点是第一个节点，就退出循环
            if (node.getNext() == first) {
                break;
            }
            node = node.getNext();
        }
        // 添加节点，构成环形
        node.setNext(studentNode);
        node=studentNode;
        node.setNext(first);
        num++;
    }

    // 展示节点
    public void show() {
        if (num == 0) {
            System.out.println("链表为空");
            return;
        }
        if (num == 1) {
            System.out.println(first);
            return;
        }
        StudentNode node = first;
        while (true) {
            System.out.println(node);
            if (node.getNext() == first) {
                break;
            }
            node = node.getNext();
        }
    }

    // pop弹出当前节点
    public void pop() {
        if (num == 0) {
            System.out.println("链表为空");
        }
        else if (num == 1) {
            System.out.println(first);
            first = null;
            num--;
        }
        else {
            StudentNode node = first;  // 辅助节点
            // 先找出当前节点的前一个节点
            while (node.getNext() != current) {
                node = node.getNext();
            }
            System.out.println(current);
            node.setNext(current.getNext());
            if (current == first) {
                first = first.getNext();
            }
            current = current.getNext();
        }
    }
}
