package com.stackDeom;

/**
 * 这个是数字栈，存放数字
 */
public class NumStack {
    private int top; //  栈顶的索引
    private int max; //  栈的最大大小
    private int[] stack;  // 数组模拟栈

    // 构造函数实现栈的初始化
    public NumStack(int max) {
        this.max = max;
        this.top = -1;  // 栈初始化的时候没有数据，默认栈顶的索引是-1
        this.stack = new int[max];
    }

    // 判断栈是否满了
    public boolean isFull() {
        return this.top == max - 1;
    }

    // 判断是否空栈
    public boolean isEmpty() {
        return this.top == -1;
    }

    // 按顺序展示数据
    public void list() {
        if (this.isEmpty()) {
            System.out.println("数字栈为空！");
        } else {
            for (int i = this.top; i > -1; i--) {
                System.out.print(stack[i]+"\t");
            }
            System.out.println();
        }
    }

    // 入栈
    public void add(int num) {
        if (this.isFull()) {
            System.out.println("数字栈满了!");
        } else {
            this.top++;
            stack[this.top] = num;
        }
    }

    // 出栈
    public int pop() {
        if (this.isEmpty()) {
            System.out.println("数字栈为空！");
            return -1;
        } else {
            return stack[this.top--];
        }
    }

    public int size() {
        return top+1;  // 获取栈中数据的数目
    }

    // 展示栈顶的数据
    public int showTop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return -1;
        }
        return stack[this.top];
    }

}
