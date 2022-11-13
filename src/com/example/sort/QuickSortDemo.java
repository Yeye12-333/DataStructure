package com.example.sort;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/8  17:06
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,3,5,2,5,8,4,8,9};
        quickSortVersion2(arr, 0 ,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序1.0
     * @param arr 原数组
     * @param l <区的边界
     * @param r >区的边界
     */
    public static void quickSortVersion1(int[] arr, int l, int r){
        if(l < r){
            int[] bound = partition(arr, l ,r);
            quickSortVersion1(arr, l, bound[0] - 1);
            quickSortVersion1(arr, bound[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r){
        //小于num区的边界
         int less = l - 1;
        //大于num区的边界
        int more = r;

        while (l < more){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if (arr[l] > arr[r]){
                swap(arr, --more, l);
            }else {
                l++;
            }
        }
        swap(arr, more, r);

        return new int[]{less, more + 1};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 快速排序2.0
     * @param arr 原数组
     * @param l <区的边界
     * @param r >区的边界
     */
    public static void quickSortVersion2(int[] arr, int l, int r){
        if(l < r){
            swap(arr, l + (int) (Math.random() * (r-l + 1)), r);
            int[] bound = partition2(arr, l, r);
            quickSortVersion1(arr, l, bound[0] - 1);
            quickSortVersion1(arr, bound[1] + 1, r);
        }
    }


    public static int[] partition2(int[] arr, int l, int r){
        int less = l - 1;
        int more = r;
        while (l < more){
            if(arr[l] < arr[r]){
                swap(arr, ++less, l++);
            }else if(arr[l] > arr[r]){
                swap(arr, --more, l);
            }else {
                l ++;
            }
        }
        swap(arr, more, r);

        return new int[]{less , more + 1};

    }
}
