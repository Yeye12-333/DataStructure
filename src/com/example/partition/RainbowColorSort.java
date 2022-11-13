package com.example.partition;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/10/10  20:10
 */
public class RainbowColorSort {
    public static void main(String[] args) {
        int[] arr = {3};

//        color[1,6] range[0,7]

        sort(1,1,0,1,arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int colorStart, int colorEnd, int rangeFrom, int rangTo,int[] arr){
            if (arr == null || arr.length < 2 ) {
                return;
            }
            if(colorStart == colorEnd){
                return;
            }
            int left = rangeFrom;
            int right = rangTo;
            System.out.println(colorStart + ":" + colorEnd);
            int midNode = (colorStart + colorEnd) / 2;
            System.out.println(midNode);
            while (left <= right){
                while (left<=right && arr[left] < midNode){
                    left ++;
                }
                while (left <= right && arr[right] >= midNode){
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
        sort(colorStart,midNode,rangeFrom,right,arr);
        sort(midNode + 1,colorEnd,left,rangTo,arr);
    }
}
