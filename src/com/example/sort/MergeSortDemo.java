package com.example.sort;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/8  14:47
 * 归并排序
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2,5,2,9,3};
//        int max = findMax(arr, 0, arr.length - 1);
//        System.out.println(max);
//        mergeSortProcess(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        int i = inverseNum(arr, 0, arr.length - 1);
        System.out.println(i);


    }

    public static int findMax(int[] arr, int l, int r){
        if(l == r){
            return arr[l];
        }
        //寻找中点
        int middle = l + ((r-l) >> 1);

        int leftMax = findMax(arr, l, middle);
        int rightMax = findMax(arr, middle + 1, r);
        return  Math.max(rightMax, leftMax);
    }

    /**
     * 归并排序：
     * @param arr 原数组
     * @param l 数组最左边的下标
     * @param r 数组最右边的下标
     */
    public static void mergeSortProcess(int[] arr, int l, int r){
        if(l == r){
            return;
        }

        int middle = l + ((r-l) >> 2);

        mergeSortProcess(arr, l,middle);
        mergeSortProcess(arr, middle + 1, r);
        merge(arr, l, middle, r);
  }

    /**
     * 合并操作
     * @param arr 原数组
     * @param l 需要操作的数字的最左边的下标
     * @param mid 中点下标
     * @param r 需要操作的数字的最右边的下标
     */
    public static void merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }

        for (int i1 = 0; i1 < help.length; i1++) {
            arr[l + i1] = help[i1];
        }
    }


    /**
     * 小和问题 在一个数组中，每一个数左边比当前这个数小的累加起来，叫做这个数组的小和，求一个数组的小和
     * @param arr 原数组
     * @param l 需要操作的数字的最左边的下标
     * @param r 需要操作的数字的最右边的下标
     * @return 该数组的小和
     */
    public static int minSum(int[] arr, int l,  int r){
        if(l == r){
            return 0;
        }
        int middle = l + ((r-l) >> 1);
        return  minSum(arr, l ,middle) + minSum(arr, middle + 1, r) + merge2(arr, l, middle, r);
    }

    public static int merge2(int[] arr, int l, int mid, int r)
    {
        int[] help = new int[r-l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[index ++] = arr[p1] < arr[p2] ? arr[p1 ++] : arr[p2 ++];
        }
        while (p1 <= mid){
            help[index ++] = arr[p1 ++];
        }
        while (p2 <= r){
            help[index ++] = arr[p2 ++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
        return  res;
    }

    /**
     * 求一对数组中的逆数对的有多少
     * 在一个数组中， 左边的数如果比右边的数大，就折两个数构成逆数对
     * @param arr 原数组
     * @param l 需要操作的数字的最左边的下标
     * @param r 需要操作的数字的最右边的下标
     * @return 逆数对的数量
     */
    public static int inverseNum(int[] arr, int l, int r){
        if(l == r){
            return 0;
        }
        int middle = l + ((r-l) >> 1);
        return inverseNum(arr, l, middle) + inverseNum(arr, middle + 1, r) + merge3(arr, l, middle, r);
    }

    public static int merge3(int[] arr, int l, int mid, int r){
        int[] help = new int[r- l + 1];
        int index = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r){
            res += arr[p1] > arr[p2] ? (r - p2 + 1) : 0;
            help[index ++] = arr[p1] > arr[p2] ? arr[p1 ++] : arr[p2 ++];
        }

        while (p1 <= mid){
            help[index ++] = arr[p1 ++];
        }
        while (p2 <= r){
            help[index ++] = arr[p2 ++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }
}
