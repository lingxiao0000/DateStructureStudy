package com.PolandCalculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "123+4*+5-"; // 这是一个逆波兰表达式，里面的都是单位数
        PolandCalculator polandCalculator = new PolandCalculator();
        int i = polandCalculator.expressCalculate(s);
        System.out.println(i);

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
    }
}
