package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/19  10:49
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Hero2 hero1 = new Hero2(1,"宋江");
        Hero2 hero2 = new Hero2(2,"卢俊义");
        Hero2 hero3 = new Hero2(3,"吴用");
        Hero2 hero4 = new Hero2(4,"林冲");

        DoubleLinkedList list = new DoubleLinkedList();
        list.addBySort(hero2);
        list.addBySort(hero3);
        list.addBySort(hero1);
        list.addBySort(hero4);

//        list.delLinked(hero4);
        list.show();

    }
}
