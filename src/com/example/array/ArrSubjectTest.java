package com.example.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yeye
 * @date 2022/11/21  11:17
 */
public class ArrSubjectTest {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,3,4,4,4,4,4,4,4,4,4,4,4,5,3};
        int[] nums1 = {1,2,3,5};
        System.out.println(containsDuplicate(nums1));
    }
    public static int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        Arrays.sort(nums);
        int res = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if(  i+1 < nums.length && nums[i] == nums[i+1] ){
                count ++;
            }else {
                if(count > (nums.length / 2)){
                    res = nums[i];
                    break;
                }
                count = 1;
            }
        }
        return res;
    }

    public static boolean containsDuplicate(int[] nums) {
        if(nums.length <= 1 ){
            return false;
        }
        Arrays.sort(nums);
        int cur = 0;
        int next = 1;
        while (next < nums.length){
            if(nums[cur] == nums[next]){
                return true;
            }else {
                cur ++;
                next ++;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        if(nums.length <= 1 ){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num :nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return  false;
    }
}
