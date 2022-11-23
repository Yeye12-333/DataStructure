package com.example.linkedlist;

import java.util.*;

/**
 * @author yeye
 * @date 2022/10/25  10:19
 */
public class ListNodeTest {
    private static ArrayList<Integer> reversePrint03Arr = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(Math.pow(2,10));
        ListNode l0 = new ListNode(0);
        ListNode l00 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(0);
        ListNode l8 = new ListNode(-4);

        ListNodeList list = new ListNodeList();
        list.setHead(l00);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.show();
        System.out.println("====================================");

        ListNodeList list2 = new ListNodeList();
        list2.setHead(l0);
        list2.add(l6);
        list2.add(l5);
        list2.add(l4);
        list2.show();

        System.out.println("====================================");
        System.out.println(deleteNode(list.getHead(),2));
        mergeTwoLists(list.getHead(), list2.getHead());
    }



    /**
     * 用迭代的方法反转链表
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 用递归的方式反转链表
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList02(ListNode head) {

        return reverseRecur(head, null);
    }

    public ListNode reverseRecur(ListNode cur, ListNode pre){
        if(cur == null){return pre;};
        ListNode res = reverseRecur(cur.next, cur);
        cur.next = pre;
        return res;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }
        ListNode l = l1;
        ListNode r = l2;
        ListNode list = new ListNode(-1);
        ListNode temp = list;
        while(l != null && r != null){
            if(l.val > r.val){
                temp.next = r;
                r = r.next;
            }else{
                temp.next = l;
                l = l.next;
            }
            temp = temp.next;
        }
        if(l != null){temp.next = l;};
        if(r != null){temp.next = r;};
        return list.next;
    }

    /**
     * 方法一：压栈
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head 一个链表的头节点
     * @return 数组
     */
    public static int[] reversePrint01(ListNode head) {
        //第一种方法： 将链表压入栈中
        if(head.next == null){
            return null;
        }
        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            result[index] = stack.pop();
            index ++;
        }
        return result;
    }

    /**
     * 方法二：先反转链表，再遍历
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head 一个链表的头节点
     * @return 数组
     */
    public static int[] reversePrint02(ListNode head) {
        if(head == null){
            return new int[0];
        }
        //反转链表
        ListNode pre = null;
        ListNode cur = head;
        int size = 0;
        while (cur != null){
            size ++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        ListNode temp = pre;
        System.out.println(size);
        int[] res = new int[size];
        int index = 0;
        while (temp != null){
            res[index] = temp.val;
            temp = temp.next;
            index ++;
        }
        return  res;
    }
    /**
     * 方法三：使用递归
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head 一个链表的头节点
     * @return 数组
     */
    public static int[] reversePrint03(ListNode head) {
        if(head == null){
            return new int[0];
        }
        recursion(head);
        int[] result = new int[reversePrint03Arr.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = reversePrint03Arr.get(i);
        }
        System.out.println(Arrays.toString(result));
        return  result;
    }

    public static void recursion(ListNode head){
        if (head == null) {
            return;
        }
        recursion(head.next);
        reversePrint03Arr.add(head.val);
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。方法一
     * @param head 单向链表的头指针
     * @param val  一个要删除的节点的值
     * @return 返回删除后的链表的头节点
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head.val == val ? null : head;
        }


        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        ListNode temp = newNode;
        while(temp != null && temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next == null ? null : temp.next.next;
            }
            temp = temp.next;
        }
        return newNode.next;
    }


    public static ListNode deleteNode2(ListNode head, int val) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head.val == val ? null : head;
        }


        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        ListNode temp = newNode;
        while(temp != null && temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next == null ? null : temp.next.next;
            }
            temp = temp.next;
        }
        return newNode.next;
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
