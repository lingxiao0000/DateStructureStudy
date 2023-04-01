package com.PolandCalculator;

/**
 * 栈结构
 */
public class Stack {
    private int max; // 栈的最大数据大小
    private int[] stack;
    private int top;  // 指向栈顶的索引

    // 构造函数初始化栈
    public Stack(int max) {
        this.max = max;
        this.top = -1;
        this.stack = new int[max];
    }

    public boolean isFull() {
        return top == max-1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("栈已满");
        }else {
            stack[++top] = num;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int showTop() {
        return stack[top];
    }

    public int getTop() {
        return top;
    }
}
