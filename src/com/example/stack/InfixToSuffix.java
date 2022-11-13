package com.example.stack;

import java.util.Stack;

/**
 * @author yeye
 * @date 2022/11/1  9:25
 */
public class InfixToSuffix {
    public static void main(String[] args) {
        String res = parse("1+((2+3)*4)-5");
        System.out.println(res);
    }

    public static String parse(String expression) {
        StringBuilder result = new StringBuilder();
        StringBuilder keepNum = new StringBuilder();
        //符号栈
        Stack<String> s1 = new Stack<>();
        //表达式栈
        Stack<String> s2 = new Stack<>();
        int index = 0;
        while (index <= expression.length() - 1) {
            char str = expression.charAt(index);
            if (isOper(str)) {
                //如果是运算符
                while (true) {
                    if (s1.isEmpty()) {
                        s1.push(expression.substring(index, index + 1));
                        break;
                    } else {
                        //如果符号栈不为空
                        String opr = s1.peek();
                        if (weight(opr.charAt(0)) < weight(str) || isBrackets(opr.charAt(0))) {
                            s1.push(expression.substring(index, index + 1));
                            break;
                        } else {
                            s2.push(s1.pop());
                        }
                    }
                }
            } else if (isBrackets(str)) {
                if (str == '(') {
                    s1.push(expression.substring(index, index + 1));
                } else if (str == ')') {
                    while (!"(".equals(s1.peek())){
                        s2.push(s1.pop());
                    }
                    s1.pop();
                }
            } else {
                //如果是数字
                keepNum.append(str);
                if (index == expression.length() - 1) {
                    s2.push(keepNum.toString());
                } else {
                    int count = index + 1;
                    while (!isOper(expression.charAt(count)) && !isBrackets(expression.charAt(count))) {
                        keepNum.append(expression.charAt(count));
                        count++;
                        if (count > expression.length() - 1) {
                            break;
                        }
                    }
                    s2.push(keepNum.toString());
                    index = count;
                    keepNum = new StringBuilder();
                    continue;
                }
            }
            index++;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        while (!s2.isEmpty()) {
            result.append(s2.pop());
        }
        return result.reverse().toString();
    }

    /**
     * 设定符号权重
     *
     * @param oper 符号
     * @return 权重
     */
    public static int weight(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public static boolean isOper(int oper) {
        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    public static boolean isBrackets(int oper) {
        return oper == '(' || oper == ')';
    }

}
