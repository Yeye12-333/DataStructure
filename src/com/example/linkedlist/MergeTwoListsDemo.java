package com.example.linkedlist;

import java.util.LinkedList;

/**
 * @author yeye
 * @date 2022/10/17  10:50
 */
public class MergeTwoListsDemo {

    public static void main(String[] args) {
        Hero hero1 = new Hero(1,"宋江");
        Hero hero2 = new Hero(2,"卢俊义");
        Hero hero3 = new Hero(3,"吴用");
        Hero hero4 = new Hero(4,"林冲");

        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(hero1);
        list1.add(hero4);
        list1.add(hero3);
        list1.add(hero2);

        Hero hero5 = new Hero(1,"宋江");
        Hero hero6 = new Hero(2,"卢俊义");
        Hero hero7= new Hero(3,"吴用");
        Hero hero8 = new Hero(4,"林冲");

        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(hero6);
        list2.add(hero5);
        list2.add(hero8);
        list2.add(hero7);

        mergeTwoLists(list1,list2);
    }

    public static SingleLinkedList mergeTwoLists(SingleLinkedList list1, SingleLinkedList list2) {
        Hero head1 = list1.getHead();
        Hero head2 = list2.getHead();
        SingleLinkedList newList = new SingleLinkedList();
        Hero temp = newList.getHead();
        temp = addLinked(head1, temp);
        addLinked(head2, temp);
        sortLinked(newList);
        newList.show();
        return newList;
    }

    public static Hero addLinked(Hero hero, Hero temp){
        while (hero.next != null){
            temp.next = hero.next;
            hero = hero.next;
            temp = temp.next;
        }
        return temp;
    }

    public static void sortLinked(SingleLinkedList link){
        link.show();
        System.out.println("===============================");
        Hero slow = link.getHead();
        Hero fast = link.getHead().next;
        Hero temp = null;
        while (fast!= null){
            if(slow.id > fast.id){
                temp = slow.next;
                slow.next = fast.next;
                fast.next = temp;
                fast = slow.next;
                slow = fast.next.next;
            }else {
                fast = fast.next;
                slow = slow.next;
            }
        }
    }
}
