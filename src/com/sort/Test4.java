package com.sort;

// 这里进行希尔排序的测试
public class Test4 {
    public static void main(String[] args) {
        int[] array = new int[]{2,54,72,4,74,7,32,6,7,4,454,63,6,73,2456,57,36,25,564,5132,6,5,515,76,451,5,67356,24,53,635,42,6};
        sort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    // 希尔排序
    public static void sort(int[] array) {
        // 遍历步长
        for (int gap=array.length/2; gap>=1; gap=gap/2) {
            // 遍历无序列表
            for (int i=gap;i<array.length;i+=gap) {
                // 遍历有序列表
                for (int j= i;j-gap>0;j-=gap) {
                    if (array[j] < array[j-gap]) {
                        int temp = array[j];
                        array[j] = array[j-gap];
                        array[j-gap] = temp;
                    }
                }
            }
        }
    }
}
