package com.example.stack;

/**
 * @author yeye
 * @date 2022/10/26  10:38
 */
public class StackObj {
    int maxSize;
    int top = -1;
    int[] stack = null;

    public StackObj(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public void push(int num){
        if(isFull()){
            System.out.println("栈已经满啦！！");
            return;
        }
        top ++;
        stack[top] = num;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("栈中已经没有元素啦");
            return 0;
        }
        int temp = stack[top];
        top --;
        return temp;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public int getTop(){
        return stack[top];
    }

    public  void  show(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
