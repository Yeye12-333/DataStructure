package com.example.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yeye
 * @date 2022/10/25  10:19
 */
public class ListNodeTest {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(0);
        ListNode l8 = new ListNode(-4);

        ListNodeList list = new ListNodeList();
        list.add(l3);
        list.add(l2);
        list.add(l7);
        list.add(l8);
        l8.next = l2;
        list.show();
        System.out.println("====================================");

//        System.out.println(isPalindrome2(list.getHead()));
    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head){
        if(head == null){
            return  null;
        }


        return null;
    }

    /**
     * 判断是否为回文链表，解法一
     * 将链表放入list 集合中，然后利用相向双指针，判断是否回文
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }

        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        int right = 0;
        int left = list.size() - 1;

        while (right <= left){
            if(!list.get(right).equals(list.get(left))){
                return false;
            }
            right ++;
            left --;
        }
        return true;
    }

    /**
     * 判断是否为回文链表，解法二
     * 利用快慢指针，先找到中间项，然后反转后半部分，然后再将前半部分与后半部分进行比较
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null){
                break;
            }
        }
        System.out.println("*****************");
        slow = reverse(slow);
        System.out.println(slow);

        fast = head;
        while (slow != null){
            System.out.println(fast);
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
