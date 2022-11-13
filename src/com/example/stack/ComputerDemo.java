package com.example.stack;

/**
 * @author yeye
 * @date 2022/10/30  9:40
 */
public class ComputerDemo {
    public static void main(String[] args) {
        String expression = "360/180*25";
        computer(expression);
    }

    public static void computer(String expression){
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        StringBuilder keepNum = new StringBuilder();
        StackObj numStack = new StackObj(7);
        StackObj opreStack = new StackObj(7);
        int index = 0;
        while (index <= expression.length() - 1){
            char str = expression.charAt(index);
            if(isOper(str)){
                if(opreStack.isEmpty()){
                    opreStack.push(str);
                }else {
                    if(weight(str) <= weight(opreStack.getTop())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = opreStack.pop();
                        res = compute(num1,num2,oper);
                        numStack.push(res);
                        opreStack.push(str);
                    }else {
                        opreStack.push(str);
                    }
                }
            }else {
                keepNum.append(str);
                if(index == expression.length() - 1){
                    numStack.push(Integer.parseInt(keepNum.toString()));
                }else {
                    int count = index + 1;
                    while (!isOper(expression.charAt(count))){
                        keepNum.append(expression.charAt(count));
                        count ++;
                        if(count > expression.length() - 1){
                            break;
                        }
                    }
                    numStack.push(Integer.parseInt(keepNum.toString()));
                   keepNum = new StringBuilder();
                   index = count;
                   continue;
                }
            }
            index ++;
        }
        numStack.show();
        System.out.println("=====================");
        opreStack.show();
        while (!opreStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = opreStack.pop();
            res = compute(num1,num2,oper);
            numStack.push(res);
        }
        System.out.println(res);

    }

    /**
     * 设定符号权重
     * @param oper 符号
     * @return 权重
     */
    public static int weight(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return  0;
        }else {
            return -1;
        }
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
                res = num2 / num1;
                break;
            default:
                res = num2 - num1;
        }
        return res;
    }

}
