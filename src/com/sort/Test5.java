package com.sort;

// 快速排序的测试
public class Test5 {
    public static void main(String[] args) {
        int[] array = new int[]{45,786,345,767,21,346,68,2,647,2,345,753,134,7534,245,75};
        quickSort(array);
        for (int i : array) {
            System.out.print(i+"\t");
        }
    }
    public static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    public static void quickSort(int[] array,int start,int end) {
        if (end - start >1) {
            int i = start;
            int j = end;
            int index = i;  // 分界值的索引值,从第一个值开始
            int value = array[index];
            boolean flag = true;
            while (i<j) {
                if (flag) {
                    if (array[j] < value) {
                        array[index] = array[j];
                        array[j] = value;
                        index = j;
                        flag = false;
                    }
                    j--;
                } else {
                    if (array[i] > value) {
                        array[index] = array[i];
                        array[i] = value;
                        index = i;
                        flag = true;
                    }
                    i++;
                }
            }
            // 继续排序左边的部分
            quickSort(array,0,index);
            // 继续排序右边的部分
            quickSort(array,index+1,end);
        }
    }
}
