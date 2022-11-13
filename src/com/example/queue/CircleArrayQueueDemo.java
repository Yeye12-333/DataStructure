package com.example.queue;

import java.util.Scanner;

/**
 * @author yeye
 * @date 2022/10/6  14:36
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);
        Scanner scanner = new Scanner(System.in);
        Boolean loop = true;
        while (loop) {
            System.out.println("a(add): 添加数据到队列");
            System.out.println("s(show): 显示队列");
            System.out.println("g(get): 从队列获取数据");
            System.out.println("h(header): 获取队列的第一个头数据");
            System.out.println("e(exit): 退出程序");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int queue1 = queue.getQueue();
                        System.out.printf("从队列中取出的数据是：%d\n", queue1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int header = queue.showHeader();
                        System.out.printf("队列中的头数据是：%d\n", header);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }

        }
        System.out.println("程序退出");
    }
}
