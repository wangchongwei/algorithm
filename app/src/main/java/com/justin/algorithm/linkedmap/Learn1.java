package com.justin.algorithm.linkedmap;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * bilibili学习题
 * 给出两个单向链表的头部节点head1,head2
 * 1、判断链表中是否存在环形，如果存在，返回进入环形的第一个节点n1,如果不相交，则返回null
 * 2、判断两个链表是否相交，如果相交返回相交的第一个节点n1，如果不相交返回null
 */
public class Learn1 {

    /**
     * 链表节点类
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = null;

        ListNode cycleNode = hasCycle2(node1);
        System.out.println("hasCycle: => " + (cycleNode == null ? "false" : cycleNode.val));



        ListNode no1 = new ListNode(1);
        ListNode no2 = new ListNode(2);
        ListNode no3 = new ListNode(3);
        ListNode no4 = new ListNode(4);
        ListNode no5 = new ListNode(5);
        ListNode no6 = new ListNode(6);
        ListNode no7 = new ListNode(7);
        ListNode no8 = new ListNode(8);
        ListNode no9 = new ListNode(9);
        ListNode no10 = new ListNode(10);
        ListNode no11 = new ListNode(11);

        no1.next = no5;
//        no2.next = no3;
//        no3.next = no4;
//        no4.next = no5;
        no5.next = no6;
        no6.next = node11;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;
//        node10.next = node11;
//        node11.next = null;

        ListNode crossoverPointNode = hasCrossoverPoint(node1, no1);
        System.out.println("hasCrossoverPoint: => " + (crossoverPointNode == null ? "false" : crossoverPointNode.val));
    }

    /**
     * 判断链表是否存在环形
     * 通过hash表来进行重复判断，如果存在重复元素，则表示一定存在环形结构
     *
     * @param head
     * @return
     */
    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode prev = head;
        Set<ListNode> set = new HashSet<>();
        while (prev.next != null) {
            if (set.contains(prev)) {
                // 代表已经添加过该节点，此时又进入到节点，则表面此时一定存在环形结构，且当前节点为环形节点的入口
                return prev;
            }
            set.add(prev);
            prev = prev.next;
        }
        return null;
    }


    /**
     * 判断链表是否存在环形
     * 通过快慢指针的方式判断是否存在环形结构，如果存在则返回此节点，如果不存在则返回null
     * 定义两个指针，慢指针每次走一步，快指针每次走两步，
     * 如果快慢指针会相遇，则说明存在环形结构，当相遇后，将快指针移到链表头部，并修改快指针每次只走一步，慢指针保持不变
     * 此时快慢指针肯定会二次相遇，相遇点即为环形结构的入口
     *
     * @param head
     * @return
     */
    public static ListNode hasCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode n1 = head.next; // 慢指针 每次一步
        ListNode n2 = head.next.next; // 快指针 每次两步

        while (n1 != n2) {
            // 当有一个为null时，说明不存在环形
            if (n1 == null || n1.next == null || n2 == null || n2.next == null) return null;
            n1 = n1.next;
            n2 = n2.next.next;
        }
        System.out.println("第一次相遇 : " + n1.val);
        // 当第一次相遇时，将快指针还原到链表首节点，并每次移动只走一步
        n2 = head;
        while (n1 != n2) {
            n2 = n2.next;
            n1 = n1.next;
        }
        // 此时第二次相遇
        System.out.println("第二次相遇: => " + n1.val);
        return n1;
    }


    /**
     * 判断两个链表是否含有交点，有则返回此交点，无则返回null
     * 如果两个链表相交，在两个链表中从相交节点开始，后续的节点都是公用
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode hasCrossoverPoint(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) return null;
        ListNode cycleNode1 = hasCycle2(head1);
        ListNode cycleNode2 = hasCycle2(head2);
        // 定义两个链表的长度
        int size1 = 1;
        int size2 = 1;
        if(cycleNode1 == null && cycleNode2 == null) {
            //  两个链表都不是环形结构,计算出两个链表的长度
            ListNode n1 = head1;
            ListNode n2 = head2;
            while (n1.next != null) {
                size1 ++;
                n1 = n1.next;
            }
            while (n2.next != null) {
                size2 ++;
                n2 = n2.next;
            }
            // 取出两个链表的长度差
            ListNode n3; // 长链表
            ListNode n4; // 短链表
            int d;
            if(size1 >= size2) {
                n3 = head1;
                n4 = head2;
                d = size1 - size2;
            } else {
                n3 = head2;
                n4 = head1;
                d = size2 - size1;
            }
            while (n3 != null) {
                if(n3 == n4) return n3;
                n3 = n3.next;
                if(d <= 0) n4 = n4.next;
                d --;
            }
            return null;

        } else if (cycleNode1 == null || cycleNode2 == null) {
            // 一个是环形结构，一个不是时。
            return null;
        } else {
            // 两个都是环形结构时
            //  先判断环形入口是否一样
            if(cycleNode1 == cycleNode2) {
                // 环形入口一样，则说明相交点在环形入口或之前
            } else {
                // 不一样时，说明1、不存在相交点，2、相交点在环形结构中
            }
        }
        return null;
    }
}
