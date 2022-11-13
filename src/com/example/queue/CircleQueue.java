package com.example.queue;

/**
 * @author yeye
 * @date 2022/10/6  14:37
 */
public class CircleQueue {

    private int maxSize;


    /**
     * rear 表示队列中最后一个元素的后面一个位置，表示一个预留的空间
     */
    private int rear;

    /**
     * front 表示队列中的首部，即arr[front]为队列的第一个元素
     */
    private int front;
    private int[] arr;

    public CircleQueue(int max){
        this.maxSize = max;
        this.arr = new int[this.maxSize];
    }

    /**
     * 判断队列是否满了
     */
    private boolean isFull(){
        return (this.rear + 1) % this.maxSize == this.front;
    }
    /**
     * 判断队列是否为空
     */
    private boolean isNull(){
        return this.rear == this.front;
    }

    /**
     * 显示队列
     */
    public void showQueue(){
        for (int i = this.front; i < this.front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % this.maxSize, this.arr[i % this.maxSize] );
        }
    }
    /**
     * 获取队列的有效数据
     */
    private int size(){
        return (this.rear + this.maxSize - this.front) % this.maxSize;
    }

    /**
     * 添加元素至队列
     */
    public void  addQueue(int value){
        if(isFull()){
            System.out.println("队列已满了，不能添加数据了");
            return;
        }
        this.arr[rear] = value;
        this.rear = (this.rear + 1) % this.maxSize;
    }

    /**
     * 取出队列中的元素
     */
    public int getQueue(){
        if(isNull()){
            throw new RuntimeException("队列为空，不能取出数据啦");
        }
        int value = this.arr[this.front];
        this.front = (this.front + 1) % this.maxSize;
        return value;
    }

    /**
     * 查看队首的元素
     */

    public int showHeader(){
        if(isNull()){
            throw new RuntimeException("队列为空，不能查看啦");
        }
        return this.arr[this.front];
    }
}
