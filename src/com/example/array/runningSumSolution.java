package com.example.array;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/10/19  9:43
 */
public class runningSumSolution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] arr = runningSum(nums);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] runningSum(int[] nums){
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if(fast > 0){
                nums[fast] = nums[slow] + nums[fast];
                slow ++;
            }
            fast ++;
        }
        return nums;
    }
}
