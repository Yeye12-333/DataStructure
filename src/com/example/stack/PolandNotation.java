package com.example.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yeye
 * @date 2022/10/31  10:15
 */
public class PolandNotation {

    public static void main(String[] args) {
        String expression = "1 2 3 + 4 * + 5 -";
        List<String> list = parseList(expression);
        System.out.println(list);
        int res = polandNotationCompute(list);
        System.out.println(res);
    }

    public static int polandNotationCompute(List<String> list){
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        int index = 0;
        Stack<Integer> numStack = new Stack<>();
        StringBuilder keepNum = new StringBuilder();
        for (String item :
                list){
            if(item.matches("\\d+")){
                numStack.push(Integer.parseInt(item));
            }else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                res = compute(num1, num2,item.charAt(0));
                numStack.push(res);
            }
        }

        return numStack.pop();
    }

    public static  boolean isOper(int oper){
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    /**
     * 计算
     * @param num1 第一个pop出来的数
     * @param num2 第二个pop出来的数
     * @param opre 符号
     * @return 结果
     */
    public static int compute(int num1, int num2, int opre){
        int res = 0;
        switch (opre){
            case '+':
                res = num2 + num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                if(num2 == 0){
                    return 0;
                }
                res = num2 / num1;
                break;
            default:
                if(num1 < num2){
                    res = num2 - num1;
                }else {
                    res = num1 - num2;
                }
        }
        return res;
    }

    public static List<String> parseList(String expression){
        String[] arr = expression.split(" ");
        List<String> strList = new ArrayList<>();
        strList.addAll(Arrays.asList(arr));
        return strList;
    }
}
