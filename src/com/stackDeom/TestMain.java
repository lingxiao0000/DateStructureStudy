package com.stackDeom;

// 这里实现模拟底层运算表达式的处理
public class TestMain {
    public static void main(String[] args) {
        String s = "30*2*1+40*1";
        int i = Calculator.expressCalculate(s);
        System.out.println(i);
    }
}
