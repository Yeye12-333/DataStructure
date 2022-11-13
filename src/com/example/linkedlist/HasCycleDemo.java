package com.example.linkedlist;


/**
 * @author yeye
 * @date 2022/10/22  10:31
 */
public class HasCycleDemo {
    public static void main(String[] args) {
        Hero hero1 = new Hero(1,"宋江");
        Hero hero2 = new Hero(2,"卢俊义");
        Hero hero3 = new Hero(3,"吴用");
        Hero hero4 = new Hero(4,"林冲");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);

//        hero2.next = hero3;
        System.out.println(hasCycle(singleLinkedList.getHead()));
    }
    public static Boolean hasCycle(Hero head){
        if(head == null || head.next == null){
            return false;
        }
        Hero slow = head;
        Hero fast = head.next;
        while (slow.id != fast.id){
            if(fast.next.next == null || slow.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
