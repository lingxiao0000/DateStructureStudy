package com.sort;

// 这里实现选择排序
public class Test2 {

    public static void main(String[] args) {
        int[] array = new int[]{2,6,1,7,8,3254,8,235,845,14,6,43};
        sort(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }
    }

    public static void sort(int[] array) {
        // 实现从小到大排序
        for (int i=0;i<array.length;i++) {
            int index = i;  // 最小值的索引
            for (int j=i+1;j<array.length;j++) {
                if (array[j]<array[index]) {
                    index = j;  // 如果找到更小的数，变更索引值
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}
