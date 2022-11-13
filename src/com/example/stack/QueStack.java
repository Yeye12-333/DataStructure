package com.example.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yeye
 * @date 2022/11/2  9:33
 * 用队列实现栈
 */
public class QueStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public QueStack(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int num){
        q2.offer(num);
        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return  q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
