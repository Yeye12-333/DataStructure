package com.example.linkedlist;

/**
 * @author yeye
 * @date 2022/10/25  10:19
 */
public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                '}';
//    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
