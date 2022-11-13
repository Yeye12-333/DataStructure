package com.example.sort;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/10  20:24
 */
public class BucketSortDemo {

    public static void main(String[] args) {
        int[] arr = {12,53,5345,23,34,23,4,1,85,46,98};
//        System.out.println(((12 / ((int)Math.pow(10, 0))) % 10));
        radixSort(arr);
    }

    public static void radixSort(int[] arr){
        if(arr == null){
            return;
        }
        radixSort(arr, 0, arr.length - 1, getMax(arr));

    }

    public static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0){
            max = max / 10;
            res ++;
        }
        return res;
    }

    public static void radixSort(int[] arr, int L, int R, int digit){
        final  int MAXSIZE = 10;
        int[] bucket = new int[R - L + 1];
        int j = 0, index=0;
        for (int d = 1; d <= digit; d++){
            int[] count = new int[MAXSIZE];

            for (int i=L;i<=R;i++){
                j = getDigit(arr[i], d);
                count[j] ++;

            }
            for (int i = 1; i < MAXSIZE;i++){
                count[i] = count[i - 1] + count[i];
            }

            for (int i = R; i >= L; i--){
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j] --;
            }

            System.out.println("========================");
            System.out.println(Arrays.toString(bucket));

            for (index = L, j = 0; index <= R; index++, j++) {
                arr[index] = bucket[j];
            }

        }
        System.out.println(Arrays.toString(bucket));

    }

    public static int getDigit(int x,int d){
        return ((x / ((int)Math.pow(10, d-1))) % 10);
    }
}
