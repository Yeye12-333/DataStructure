package com.example.recursion;

/**
 * @author yeye
 * @date 2022/11/7  9:18
 */
public class findArrayMax {
    public static void main(String[] args) {

    }

        /**
         * 用递归寻找数组中的最大值
         * @param arr 原数组
         * @param l 左边的下标
         * @param r 右边的下标
         * @return 找到的最大值
         */
        public static int proccess(int[] arr, int l, int r){
            //如果数组中只有一个数，那么直接返回了
            if(l == r){
                return arr[l];
            }
            //寻找中点的位置
            int mid = l + ((r-l) >> 1);
            int leftMax = proccess(arr, l, mid);
            int rightMax = proccess(arr, mid + 1 ,r);
            return Math.max(leftMax, rightMax);
        }
}
