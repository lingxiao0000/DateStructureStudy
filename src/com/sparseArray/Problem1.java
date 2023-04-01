package com.sparseArray;

/**
 * 这里进行稀疏数组的学习
 * 稀疏数组的作用主要是用来压缩二维数组
 */
public class Problem1 {

    public static void main(String[] args) {
        // 首先创建二维数组,并且进行初始化
        // 模拟棋盘，1代表黑子，2代表白子
        int[][] chessArr = new int[11][11];
        chessArr[3][4] = 1;
        chessArr[4][6] = 2;

        // 这里我们不知道二维数组中有多少个个数，需要进行遍历，统计子的个数,顺便打印棋盘
        // 这里直接设置一个map集合用于存放值。
        System.out.println("原二维数组：");
        int num = 0;
        for (int[] list : chessArr) {
            for (int i : list) {
                System.out.printf("%d\t",i);
                if (i != 0) {
                    num++;
                }
            }
            System.out.println();
        }
        System.out.printf("棋子的个数是：%d",num);
        System.out.println();

        // 接下来创建对应的稀疏数组,根据稀疏数组的特点，可以确定稀疏数组的整体大小3行num+1列
        int[][] sparseArray = new int[3][num+1];
        // 首先要知道，稀疏数组的第一行是用来存放数组整体信息的
        sparseArray[0][0] = chessArr.length;  // 首先是行数
        sparseArray[0][1] = chessArr[0].length;   // 接着是存放列数
        sparseArray[0][2] = num;  // 接着是存放非0值的个数
        // 遍历二维数组，接着往稀疏数组当中存放值
        int count = 1; // count用于记录存放数据到第几行
        for (int i=0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                    count++;
                }
            }
        }
        // 遍历输出稀疏数组
        for (int[] list : sparseArray) {
            for (int i : list) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }

        // 接着执行将稀疏数组转换成二维数组的操作
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int total = sparseArray[0][2];
        int[][] chessArr2 = new int[row][col];
        for (int i=0;i<total;i++) {
            int a = sparseArray[i+1][0]; // 获取行数
            int b = sparseArray[i+1][1]; // 获取列数
            int v = sparseArray[i+1][2]; // 获取值
            chessArr2[a][b] = v;
        }
        System.out.println("重新输出的二维数组：");
        // 遍历输出转化后的二维数组
        for (int[] list : chessArr2) {
            for (int i : list) {
                System.out.printf("%d\t",i);
            }
            System.out.println();
        }
    }
}
