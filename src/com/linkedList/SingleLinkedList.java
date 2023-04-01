package com.linkedList;

/**
 * 单向链表
 */
public class SingleLinkedList {
    private HeroNode head = new HeroNode("",0);  // 头节点,不存储数据

    // 往尾部添加节点
    public void add(HeroNode heroNode) {
        HeroNode node = head;  // 辅助节点
        if (head != null) {
            // 获取最后的节点
            while (true) {
                if (node.getNext() == null) {
                    break;
                }
                else {
                    node = node.getNext();
                }
            }
            // 往链表后面添加节点
            node.setNext(heroNode);
        }
        else {
            System.out.println("链表为空,为初始化");
        }
    }

    // 遍历节点显示
    public void show() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
        }
        else {
            HeroNode node = head.getNext();
            while (true) {
                System.out.println(node);
                if (node.getNext() != null) {
                    node = node.getNext();
                }
                else {
                    break;
                }
            }
        }
    }
}
