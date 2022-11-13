package com.example.partition;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/10/11  10:14
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] arr = {2,0,6,9,0,0,5};
        moveZeroSort(arr);
    }
    public static  void moveZeroSort(int[] arr){
       int fillPointer = 0;
       int movePointer = 0;
       while (movePointer < arr.length){
           if(arr[movePointer] != 0){
                if(movePointer != fillPointer){
                 arr[fillPointer] = arr[movePointer];
                }
                fillPointer ++;
           }
             movePointer ++;
           System.out.println(movePointer);
       }

       while (fillPointer < arr.length){
            if(arr[fillPointer] != 0){
                arr[fillPointer] = 0;
            }
            fillPointer ++;
       }
        System.out.println(Arrays.toString(arr));
    }
}
