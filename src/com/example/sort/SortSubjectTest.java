package com.example.sort;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/21  9:27
 * 排序有关的题目
 */
public class SortSubjectTest {
    public static void main(String[] args) {

        int[] num1 = {1,2,5,0,0,0};
        int[] num2 = {2,2,6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }


    /**
     * 88. 合并两个有序数组
     * @param nums1  给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2
     * @param m num1 的长度
     * @param nums2 整数数组 nums2
     * @param n n num2 的长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if(n == 0){
            return;
        }
        for (int i = m,j = 0 ; i < (n + m); i++, j++) {
            nums1[i] = nums2[j];
        }
        recurs(nums1, 0, (n+m-1));
    }

    public static void  recurs(int[] arr, int l, int r){
        if(l == r){
            return;
        }
        int mid = l + ((r-l) >> 1);

        recurs(arr, l, mid);
        recurs(arr, mid + 1, r);
        mergeSort(arr, l, mid, r);
    }

    public static void mergeSort(int[] arr, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = mid + 1, index = 0;
        while (p1 <= mid && p2 <= r){
            help[index ++] = arr[p1] < arr[p2] ? arr[p1 ++] : arr[p2 ++];
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
    }
}
