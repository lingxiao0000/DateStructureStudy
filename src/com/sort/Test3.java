package com.sort;

// 这里展示插入排序算法的实现
public class Test3 {
    public static void main(String[] args) {
        int[] array = new int[]{786,345,767,21,346,68,2,647,2};
        sort(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }
    }

    public static void sort(int[] array) {
        for (int i = 1;i<array.length;i++) {
            int indexValue = i;  // 插入位置的辅助值
            int value = array[i];  // 当前查找插入位置的值
            while (indexValue > 0 && array[indexValue-1]>value) {  // 这个循环用于查找插入位置,直到找到当前插入位置
                array[indexValue] = array[indexValue-1];
                indexValue--;
            }
            array[indexValue] = value;
        }
    }
}
