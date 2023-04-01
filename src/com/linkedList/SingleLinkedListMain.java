package com.linkedList;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();  // 初始化链表
        linkedList.show(); // 输出为空
        linkedList.add(new HeroNode("张飞",1));
        linkedList.add(new HeroNode("李四",2));
        linkedList.show(); // 输出
    }
}
