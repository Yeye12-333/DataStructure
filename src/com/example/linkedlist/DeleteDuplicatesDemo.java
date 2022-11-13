package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/21  9:07
 */
public class DeleteDuplicatesDemo {
    public static void main(String[] args) {
        Hero hero1 = new Hero(1,"宋江");
        Hero hero2 = new Hero(2,"卢俊义");
        Hero hero8 = new Hero(2,"卢俊义");
        Hero hero9 = new Hero(2,"卢俊义");
        Hero hero3 = new Hero(3,"吴用");
        Hero hero4 = new Hero(3,"吴用");
        Hero hero5 = new Hero(3,"吴用");
        Hero hero6 = new Hero(3,"吴用");
        Hero hero7 = new Hero(4,"林冲");
        Hero hero10 = new Hero(4,"林冲");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addOrder(hero1);
        singleLinkedList.addOrder(hero2);
        singleLinkedList.addOrder(hero3);
        singleLinkedList.addOrder(hero4);
        singleLinkedList.addOrder(hero5);
        singleLinkedList.addOrder(hero6);
        singleLinkedList.addOrder(hero7);
        singleLinkedList.addOrder(hero8);
        singleLinkedList.addOrder(hero9);
        singleLinkedList.addOrder(hero10);



        deleteDuplicates(singleLinkedList.getHead());
        singleLinkedList.show();
    }

    public static Hero deleteDuplicates(Hero head){
        Hero slow = head;
        Hero fast = head.next;
        if(head.next == null || head.next.next == null){
            return head;
        }
        while(fast != null){
            while (fast.id == slow.id){
                slow.next = fast.next;
                fast = fast.next;
                if(fast == null){
                    return head;
                }
            }
            fast = fast.next;
            slow = slow.next;
        }
        return head;
    }
}
