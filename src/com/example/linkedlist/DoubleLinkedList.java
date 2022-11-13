package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/19  10:44
 * 双向链表
 */
public class DoubleLinkedList {
    private Hero2 head = new Hero2(0, "");

    public Hero2 getHead() {
        return head;
    }

    /**
     * 再双向链表中添加数据
     * @param hero
     */
    public void add(Hero2 hero){
        Hero2 temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = hero;
        hero.pre = temp;
    }

//2,3,1,4,3  1234 3
    public void addBySort(Hero2 hero){
        Hero2 temp = head;
        while (temp.next != null){
            if(temp.next.id >= hero.id){
                break;
            }
            temp = temp.next;
        }
        hero.next = temp.next;
        temp.next = hero;
        hero.pre = temp;
    }

    /**
     * 打印双向链表中的数据
     */
    public void show(){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Hero2 temp = head;
        while (temp.next != null){
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void delLinked(Hero2 hero){
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        Hero2 temp = head;
        while (temp.next != null){
            if(temp.id == hero.id){

                break;
            }
            temp = temp.next;
        }
        temp.pre.next = temp.next;
        if(temp.next != null){
            temp.next.pre = temp.pre;

        }
    }
}
