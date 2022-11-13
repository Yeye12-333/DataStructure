package com.example.sort;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/9  11:29
 * 堆排序
 * 大根堆： 每一颗子树的最大值就是该子树的根节点
 * 小根堆： 每一棵子树的最小值就是该字数的根节点
 */
public class HeapSortDemo {

    static int[] heap = new int[8];
    static  int heapSize = 0;
    public static void main(String[] args) {
        int[] arr = {7,2,4,5,3,6,8,3,7,9,2,1};

        heapSize = arr.length - 1;
        heapSort(arr, heapSize);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr, int heapSize){
        if(arr.length <= 2 || arr == null){
            return;
        }

        for (int i = 0; i <= heapSize; i++) {
            heapInsert(arr, i);
        }
        while (heapSize != 0){
            heapify(arr, 0, heapSize--);
        }
    }

    /**
     * 创建大根堆
     * @param arr 原数组
     * @param index 堆的大小
     */
    public static void heapInsert(int[] arr,int index){
            while (arr[index] > arr[(index - 1) / 2]){
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 改变大根堆
     * @param arr 原数组
     * @param index 索引
     * @param heapSize 堆的大小
     */
    public static int heapify(int[] arr, int index,int heapSize){
        int temp = arr[0];
        swap(arr, 0, heapSize);
        int left = 2 * index + 1;
        while (left < heapSize){
            int large = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            large = arr[large] > arr[index] ? large : index;
            if(large == index){
                break;
            }
            swap(arr, index, large);
            index = large;
            left = 2 * index + 1;
        }
        return temp;
    }
}
