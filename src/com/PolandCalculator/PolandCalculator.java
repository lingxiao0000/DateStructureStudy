package com.PolandCalculator;

/**
 * 这个类用来实现对逆波兰表达式的处理
 */
public class PolandCalculator {
    private final Stack stack = new Stack(10);

    public PolandCalculator() {

    }

    /**
     * 计算逆波兰表达式
     * @param expression 逆波兰表达式
     * @return
     */
    public int expressCalculate(String expression) {
        char[] chars = expression.toCharArray();
        int value = 0;
        for (char aChar : chars) {
            // 如果是符号,直接运算
            // 还会将运算结果塞入栈中
            if (isOpera(aChar)) {
                stack.add(calculate(stack.pop(), stack.pop(), aChar));
            }
            // 如果不是符号,这里只处理单位数字,直接入栈
            else {
                stack.add(Integer.parseInt(String.valueOf(aChar)));
            }
        }
        return stack.pop();
    }

    /**
     * 判断是否是运算符
     * @return
     */
    public static boolean isOpera(char c) {
        // 现在只支持加减乘除
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * 用于直接运算
     * @param num1 符号后的数字
     * @param num2 符号前的数字
     * @param opera 运算符号
     * @return
     */
    public static int calculate(int num1, int num2, char opera) {
        int value = 0;
        // 根据传进来的运算符进行运算
        switch (opera) {
            case '+' -> {
                value = num1 + num2;
            }
            case '-' -> {
                value = num2 - num1;
            }
            case '*' -> {
                value = num1 * num2;
            }
            case '/' -> {
                value = num2 / num1;
            }
        }
        return value;
    }

}
