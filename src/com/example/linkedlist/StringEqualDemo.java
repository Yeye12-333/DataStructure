package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/11  16:23
 */
public class StringEqualDemo {
    public static void main(String[] args) {
     Boolean replace = areAlmostEqual("bdfdanf","bdfdanf");
        System.out.println(replace);
    }
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int index = 0;
        int left = 0;
        int right = s1.length() - 1;

        while(left <= right && !s1.equals(s2)){
            while(left <= right && chars1[left] == chars2[left]){
                left ++;
            }
            while(left <= right && chars1[right] == chars2[right]){
                right --;
            }

            if(left <= right){
                index ++;
                if(index >= 2){
                    return false;
                }
                char temp = chars2[left];
                chars2[left] = chars2[right];
                chars2[right] = temp;
                s1 = String.valueOf(chars1);
                s2 = String.valueOf(chars2);
            }
        }
        return index == 1 && s1.equals(s2);
    }
}
