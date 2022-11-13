package com.example.queue;

/**
 * @author yeye
 * @date 2022/10/6  8:59
 */
public class Queue {

    /**
     * 队列的最大存储空间
     */
    private int maxSize;

    /**
     * 队列的尾部
     */
    private int rear;

    /**
     * 队列的首部
     */
    private int front;

    /**
     * 表示队列的数组
     */
    private int[] arr;

    public Queue(int max){
        this.maxSize = max;
        this.arr = new int[this.maxSize];
        //队列的尾部，即队列的最后一个元素
        this.rear = -1;
        //队列的首部，但不包含在队列所存储的元素中，为队列的第一个元素的前一个元素
        this.front = -1;
    }

    /**
     * 判断队列是否满了
     */
    private boolean isFull(){
        return this.rear == this.maxSize - 1;
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
        for (int i = 0; i < this.arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, this.arr[i] );
        }
    }

        /**
         * 添加元素至队列
         */
        public void  addQueue(int value){
            if(isFull()){
                System.out.println("队列已满了，不能添加数据了");
                return;
            }
            this.rear ++;
            arr[this.rear] = value;
        }

    /**
     * 取出队列中的元素
     */
    public int getQueue(){
        if(isNull()){
            throw new RuntimeException("队列为空，不能取出数据啦");
        }
        this.front ++;
        return this.arr[this.front];
    }

    /**
     * 查看队首的元素
     */

    public int showHeader(){
        if(isNull()){
            throw new RuntimeException("队列为空，不能查看啦");
        }
        return this.arr[this.front + 1];
    }
}
