package com.sort;

// 这里展示冒泡排序算法
public class Test1 {
    public static void main(String[] args) {
        int[] array = new int[]{3,5,7,23,7,8,23,7,4,78};
        sort(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }
    }

    public static void sort(int[] array) {
        for (int i = 0; i<999;i++) {
            boolean flag= true;
            for (int j=1; j <array.length;j++) {
               //  如果前面的数大于后面的数，就交换
                if (array[j-1] < array[j]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
