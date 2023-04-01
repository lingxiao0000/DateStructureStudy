package com.ringLinkedList;

public class RingLinkedListMain {
    public static void main(String[] args) {
        RingLinkedList ringLinkedList = new RingLinkedList(new StudentNode("张三",1));
        ringLinkedList.add(new StudentNode("李四",2));
        ringLinkedList.add(new StudentNode("王五",3));
        ringLinkedList.add(new StudentNode("老刘",4));
        ringLinkedList.show();
        System.out.println("......");
        ringLinkedList.pop();
        System.out.println("......");
        ringLinkedList.show();
    }
}
