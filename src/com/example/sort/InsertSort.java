package com.example.sort;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/6  9:17
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1,7,3,6,1,3,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void  sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            }
        }
}
