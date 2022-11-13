package com.example.partition;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/10/10  15:26
 * 双指针解决分区问题
 */
public class PartitionDemo01 {
    public static void main(String[] args) {
        int[] arr = {-2,4,-5,3,5,-7,-3};
        sortArr(arr);
    }
//    将一对数组中的正数和负数交错排列（不按原始顺序排，正负的数量差不大于1）
    public static void sortArr(int[] arr){

        int negativeNum = partitionArr(arr);//负数的个数
        int positiveNum = arr.length - negativeNum;//正数的个数

        int left = negativeNum > positiveNum ? 1 : 0;
        int right = positiveNum > negativeNum ? arr.length - 2 : arr.length - 1;
        interLeave(left, right, arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void interLeave(int left, int right,int[] arr){
        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left += 2;
            right -= 2;
        }
    }
    public static int partitionArr(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        while (left<=right){
            while (left<=right && arr[left] < 0){
                left ++;
            }

            while (left<=right && arr[right] > 0){
                right --;
            }

            if(left<=right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left ++;
                right --;
            }
        }
        return left;
    }

}
