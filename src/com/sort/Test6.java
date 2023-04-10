package com.sort;

// 归并排序的实现
// 归并排序主要就是一个分治的思想，通过递归实现先分再合
public class Test6 {
    public static void main(String[] args) {
        int[] array = new int[]{45, 7, 134, 7534, 75};
        sort(array);
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    public static void sort(int[] arr) {
        int[] tempArr = new int[arr.length];
        sort(arr, 0, arr.length - 1, tempArr);
    }

    /**
     * 归并排序的实现
     *
     * @param arr   原数组
     * @param left  左索引
     * @param right 右索引
     */
    public static void sort(int[] arr, int left, int right, int[] tempArr) {
        // 递归结束条件
        // 只要做索引大于右索引，就可以继续拆分
        if (right > left) {
            int mid = (left + right) / 2;
            // 实现左递归
            sort(arr, left, mid, tempArr);
            // 实现右递归
            sort(arr, mid + 1, right, tempArr);
            // 合并
            merge(arr, left, mid, right, tempArr);
        }
    }

    /**
     * 合并方法
     *
     * @param arr   排序的数组
     * @param left  当前操作的数组片段的最左索引值
     * @param mid   左右两数据片段的截点索引值
     * @param right 当前操作的数组片段的最右索引值
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int len = right - left + 1;  // 临时数组的长度
        // 将需要合并的数据按从小到大顺序排进临时数组当中
        for (int i = 0; i < len; i++) {
            // 先按顺序排序
            if (leftIndex <= mid && rightIndex <= right) {
                if (arr[leftIndex] < arr[rightIndex]) {
                    tempArr[i] = arr[leftIndex];
                    leftIndex++;
                } else {
                    tempArr[i] = arr[rightIndex];
                    rightIndex++;
                }
            }
            // 如果其中一边的数据已经全部完成排序，只需要将另一边的数据直接放入临时数组当中即可
            else {
                if (leftIndex > mid) {
                    tempArr[i] = arr[rightIndex];
                    rightIndex++;
                } else {
                    tempArr[i] = arr[leftIndex];
                    leftIndex++;
                }
            }
        }
        // 排序完成之后都存储在临时数组当中，将临时数组当中的数据都拷贝入原数组中
        int tempLeft = left;
        for (int i = 0; i < len; i++) {
            arr[tempLeft] = tempArr[i];
            tempLeft++;
        }
    }


}
