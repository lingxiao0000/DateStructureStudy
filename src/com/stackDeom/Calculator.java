package com.stackDeom;

/**
 * 用于实现计算器方法的类
 */
public class Calculator {
    private static NumStack numStack = new NumStack(10);  // 数字栈
    private static OperaStack operaStack = new OperaStack(10);  // 符号栈

    /**
     * 用于表达式运算
     * @param express
     * @return
     */
    public static int expressCalculate(String express) {
        char[] chars = express.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 判断是否是符号
            if (isOpera(chars[i])) {
                // 如果符号栈为空，直接存入
                if (operaStack.isEmpty()) {
                    operaStack.add(chars[i]);
                }
                // 如果不为空，判断优先级
                else {
                    // 由于是后进先出，所以后面的运算符优先级应该比较大，越靠近栈顶，优先级就越大
                    // 如果新来的运算符优先级比较小或者等于栈中的优先级，就需要将栈中的符号运算运算使用掉，然后存入新的符号
                    if (OperaPrice(chars[i]) <= OperaPrice(operaStack.showTop()) ) {
                        // 那么先对旧的符号进行运算后存入新的符号
                        int num1 = numStack.pop(); // 旧符号的后数字
                        int num2 = numStack.pop(); // 旧符号的前数字
                        int value = calculate(num1,num2,operaStack.pop());  // 获取计算后的结果
                        numStack.add(value); // 将运算后的结果存入栈中
                        operaStack.add(chars[i]); // 将新来的符号存入符号栈中
                    }
                    // 新来的优先级大于后面的，直接入栈
                    else {
                        operaStack.add(chars[i]);
                    }
                }
            }
            // 如果不是符号，是数字,存入数字栈
            else {
                StringBuilder num = new StringBuilder();
                // 因为有可能是多位数，所以不能直接存入
                while (true) {
                    num.append(chars[i]);
                    // 如果下一位是符号或者下一位就超出表达式，就退出循环
                    if(i+1 == chars.length || isOpera(chars[i+1]))
                        break;
                    // 否则i+1
                    i++;
                }
                numStack.add(Integer.parseInt(String.valueOf(num)));
            }
        }
        // 经过上面的步骤，数字栈和符号栈中的数字都是符合规律的，可以直接进行运算
        while (true) {
            if (numStack.size() == 1) {
                break;
            } else {
                numStack.add(calculate(numStack.pop(), numStack.pop(), operaStack.pop()));
            }
        }
        // 数字栈中剩下的就是最后的结果
        return numStack.pop();
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
     * 用于返回运算符的权重
     * @param c
     * @return
     */
    public static int OperaPrice(char c) {
        switch (c) {
            case '+':
            case '-': {
                return 0;
            }
            case '*':
            case '/': {
                return 1;
            }
            default:
                return -1;
        }
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
