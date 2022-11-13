package com.example.sort;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/4  9:45
 */
public class PopSort {

    public static void main(String[] args) {
        int[] arr = {1,7,3,6,1,3,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
