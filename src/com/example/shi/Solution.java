package com.example.shi;

/**
 * @author yeye
 * @date 2022/10/10  13:29
 */
public class Solution {



    public static void main(String[] args) {
        Solution solution = new Solution();
        int trap = solution.trap(new int[]{4,2,0,3,2,5});
        System.out.println("最大雨水容积：" + trap);
    }

    public int trap(int[] height) {     // 双指针解法
        int right_max = 0, left_max = 0;
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left <= right)
        {
            int water_level = Math.min(left_max, right_max);    // 当前水位
            // 第二轮水位为4
            // 第三轮水位仍是4
            // 第四轮水位依旧是4
            if (height[left] <= water_level) {       // 左边当前柱子小于等于水位
                // 左边柱子为4   4 > 0   左边第一根柱子大于水位，不进行积攒
                // 左边指针未进行移动，仍是4，水位是4，此时水柱高度为4，不能积攒雨水，      4 - 4 = 0
                // 上一轮左边水柱贴近水位，左指针进行了移动，此时水柱高度为2，水位为4，故积攒雨水     4 - 2 = 2
                // 上一轮进行了积攒雨水，此时水柱高度为0， 水位为4，故积攒雨水      4 - 0 = 4 + 2 = 6，故雨水容积为6
                //
                ans += water_level - height[left];  // 加上水位 - 当前柱子高度
                left++;
                continue;
            }

            if (height[right] <= water_level) {
                // 右边柱子为5  5>0      右边第一根柱子大于水位，不进行积攒
                ans += water_level - height[right];
                right--;
                continue;
            }

            // 记录左右两边最大高度
            left_max = Math.max(left_max, height[left]);        // 左边最高柱子为4
            right_max = Math.max(right_max, height[right]);     // 右边最高水柱为5
        }

        return ans;
    }
}
