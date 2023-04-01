package com.eightqueen;

// 八皇后问题


public class Main {
    private static int index = 0;  // 表示当前处理第几行的皇后
    private static int total = 0;  // 符合的总数

    public static void main(String[] args) {
        int[] chessArr = new int[8]; // 用一维数组代表八皇后的棋盘，索引代表皇后的行数，值代表皇后在该行的列数
        recursion(chessArr,0); // 开始递归八皇后问题
        System.out.println("有"+total+"种摆法");
    }

    /**
     * 递归逐个拜访皇后
     * @param chessArr 棋盘
     * @param num 当前放置的皇后索引值
     */
    public static void recursion(int[] chessArr, int num) {
        // 结束条件,递归终点
        if (num == 8) {
            total++;
            show(chessArr);
        }
        // 如果没有结束
        else {
            for (int i=0;i<8;i++) {
                chessArr[num] = i;
                // 如果当前放置的位置合理
                if (check(chessArr,num)) {
                    // 递归下去
                    recursion(chessArr,num+1);
                }
                // 如果不合法就不递归
                // 这里当for循环结束就会自动回溯了
            }
        }
    }

    /**
     * 用于判断皇后放置的位置是否合法的函数
     * @param chessArr 棋盘
     * @param num 当前放置的皇后索引值
     * @return
     */
    public static boolean check(int[] chessArr,int num) {
        // 判断两个皇后是否位置合理
        for (int i=0;i<num;i++) {
            // 首先是不能在同一列
            // 其次是两个皇后的行数之差的绝对值和列数之差的绝对值不能相同，代表不能在同一个斜线上
            if (chessArr[num] == chessArr[i] || Math.abs(i-num) == Math.abs(chessArr[i] - chessArr[num])) {
                return false;
            }
        }
        // 如果上面的都符合，返回正确
        return true;
    }

    /**
     * 展示棋盘
     */
    public static void show(int[] chessArr) {
        System.out.print("[");
        for (int i=0;i<chessArr.length;i++) {
            System.out.print(chessArr[i]+"\t");
        }
        System.out.print("]");
        System.out.println();
    }

}

