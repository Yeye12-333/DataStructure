package com.example.linkedlist;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @author yeye
 * @date 2022/11/18  10:49
 */
public class ListNodeTest02 {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(0);
        ListNode l00 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(5);
        ListNode l9 = new ListNode(2);
        ListNode l10 = new ListNode(5);
        ListNode l11 = new ListNode(6);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        ListNode l14 = new ListNode(2);

        ListNodeList list = new ListNodeList();
        list.setHead(l00);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);

        list.show();
        System.out.println("====================================");

        ListNodeList list2 = new ListNodeList();
        list2.setHead(l0);
        list2.add(l8);
        list2.add(l9);
        list2.add(l10);

        list2.show();

        System.out.println("====================================");
        System.out.println(rotateRight(list.getHead(),6));

    }
    public static ListNode swapPairs01(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs01(temp.next);
        temp.next = head;
        return temp;
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        while(temp.next!= null && temp.next.next != null){
            ListNode s = temp.next;
            ListNode f = temp.next.next;
            ListNode next = f.next;
            temp.next = f;
            s.next = next;
            f.next = s;
            temp = s;
        }
        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode node = new ListNode(-1);
         ListNode temp = node;
        int num = 0;
        int digit = 0;
        while(l1!=null && l2 !=null){
            num = l1.val + l2.val + digit;
            digit = 0;
            if(num < 10){
                temp.next = new ListNode(num);
            }else{
                digit = getDigit(num, 2);
                temp.next = new ListNode(getDigit(num, 1));
            }
            temp = temp.next;
            if(l1.next == null && l2.next == null && digit != 0){
                temp.next = new ListNode(digit);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            if(digit != 0){

                num = l1.val + digit;
                digit = 0;
                if(num >= 10){
                    digit = getDigit(num, 2);
                    l1.val = getDigit(num, 1);
                }else {
                    l1.val = num;
                }
            }
            temp.next = l1;
            temp = temp.next;

            if(l1.next == null && digit != 0){
                temp.next = new ListNode(digit);
                break;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            if(digit != 0){

                num = l2.val + digit;
                digit = 0;
                if(num >= 10){
                    digit = getDigit(num, 2);
                    l2.val = getDigit(num, 1);
                }else {
                    l2.val = num;
                }

            }
            temp.next = l2;
            temp = temp.next;
            if(l2.next == null && digit != 0){
                temp.next = new ListNode(digit);
                break;
            }
            l2 = l2.next;
        }
        return node.next;
    }

    public static int getDigit(int x, int d){
        return ((x / (int)Math.pow(10, d-1)) % 10);
    }


    /**
     * 旋转链表
     * @param head 头节点
     * @param k 将链表每个节点向右移动 k 个位置。
     * @return 一个节点
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode temp = head;
        int index = 0;
        while (temp != null){
            temp = temp.next;
            index ++;
        }
        temp = head;
        if((k % index) == 0){
            return slow;
        }
        for (int i = 0; i < (k % index); i++) {
            temp = temp.next;
        }
        while (temp.next != null){
            temp = temp.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        temp.next = head;

        return res;
    }
}
