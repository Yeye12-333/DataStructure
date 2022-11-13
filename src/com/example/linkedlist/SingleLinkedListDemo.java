package com.example.linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yeye
 * @date 2022/10/7  10:25
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Hero hero1 = new Hero(1,"宋江");
        Hero hero2 = new Hero(2,"卢俊义");
        Hero hero3 = new Hero(3,"吴用");
        Hero hero4 = new Hero(4,"林冲");
        Hero hero5 = new Hero(4,"林冲");
        Hero hero6 = new Hero(2,"卢俊义");
        Hero hero7 = new Hero(4,"林冲");
        Hero hero8 = new Hero(4,"卢俊义");
        Hero hero9 = new Hero(1,"卢俊义");
        Hero hero10 = new Hero(3,"吴用");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero9);
        singleLinkedList.add(hero10);
        singleLinkedList.show();
        System.out.println("=========================================");
        System.out.println(reverseLinked(singleLinkedList.getHead()));
//        Hero newHero = new Hero(5,"小林");
//
//        singleLinkedList.update(newHero);
//        singleLinkedList.deleteBy(singleLinkedList.getHead(), 2);
        singleLinkedList.show();
    }




    private static Hero reverseLinked(Hero head){
        if(head == null){
            return null;
        }
        Hero pre = null;
        Hero cur = head;
        while (cur != null){
            Hero next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static int getSize(Hero head) {
        int size = 0;
        Hero temp = head;
        while (temp != null) {
            size ++;
            temp = temp.next;
        }
        return size;
    }

    public static void findReciprocalNode(Hero head,int k){
        if(head.next == null){
            System.out.println("链表为空");
        }
        Hero temp = head;
        ArrayList<Hero> heroes = new ArrayList<>();
        while (true){
            if (temp.next == null){
                break;
            }
            heroes.add(temp);
            temp = temp.next;
        }
        System.out.println(heroes.size() - (k - 1));
        System.out.println(heroes.get(heroes.size() - (k - 1)));
        System.out.println("==================================");
    }
}
