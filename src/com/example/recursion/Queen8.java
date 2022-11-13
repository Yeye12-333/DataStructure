package com.example.recursion;

import java.util.Arrays;

/**
 * @author yeye
 * @date 2022/11/3  10:28
 */
public class Queen8 {
    int max = 8;
    int[] arr = new int[max];
    int count = 0;
    public static void main(String[] args) {
       Queen8 queen8 = new Queen8();
       queen8.check(0);
    }

    public void check(int n) {
        if (n == max) {
            print();
            count ++; 
            System.out.println(count);
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    /**
     * 判断当前这个第n个皇后是否和之前已摆好的皇后有冲突
     * arr[i] == arr[n] 冲突一： 判断该皇后是否与之前的某一个皇后处于同一列
     * Math.abs(i - n) == Math.abs(arr[i] - arr[n]) 冲突二： 判断该皇后是否与之前的某一个皇后处于同意斜线
     * 还有一个冲突三： 判断皇后是否与之前的某一个皇后处于同一行，但是n是不断变化的，且n表示的就是对应的第n个皇后还有第n个皇后所在的第n行
     * 还有一个冲突三： 判断皇后是否与之前的某一个皇后处于同一行，但是n是不断变化的，且n表示的就是对应的第n个皇后还有第n个皇后所在的第n行，所以n不需要进行判断
     * arr = {0}
     *
     * @param n 第n个皇后
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            Boolean isCol = arr[i] == arr[n];
            Boolean isK = Math.abs(n - i) == Math.abs(arr[n] - arr[i]);
            if (isCol || isK) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印最后皇后摆放的正确方法
     *皇后摆放的方法
     * @param
     */
    public  void print() {
        System.out.println(Arrays.toString(arr));
    }
}
