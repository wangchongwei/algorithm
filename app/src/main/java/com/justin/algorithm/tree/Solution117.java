package com.justin.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {


    public static void main(String[] args) {
//        TreeNode no1 = new TreeNode(1);
//        TreeNode no2 = new TreeNode(2);
//        TreeNode no3 = new TreeNode(3);
//        TreeNode no4 = new TreeNode(4);
//        TreeNode no6 = new TreeNode(6);
//        TreeNode no7 = new TreeNode(7);
//
//        TreeNode no8 = new TreeNode(8);
//        TreeNode no9 = new TreeNode(9);
//        TreeNode no10 = new TreeNode(10);
//        TreeNode no11 = new TreeNode(11);
//
//        TreeNode no12 = new TreeNode(12);
//        TreeNode no15 = new TreeNode(15);
//        no1.left = no2;no1.right = no3;
//        no2.left = no4;
//        no3.left = no6;no3.right = no7;
//        no4.left = no8;no4.right = no9;
//        no6.left = no12;
//        no7.right = no15;
        
        TreeNode no1 = new TreeNode(1);
        TreeNode no2 = new TreeNode(2);
        TreeNode no5 = new TreeNode(5);
        TreeNode no3 = new TreeNode(3);
        TreeNode no4 = new TreeNode(4);
        TreeNode no6 = new TreeNode(6);
        TreeNode no7 = new TreeNode(7);

        TreeNode no8 = new TreeNode(8);
        TreeNode no9 = new TreeNode(9);
        TreeNode no10 = new TreeNode(10);
        TreeNode no11 = new TreeNode(11);

        TreeNode no12 = new TreeNode(12);
        TreeNode no13 = new TreeNode(13);
        TreeNode no14 = new TreeNode(14);
        TreeNode no15 = new TreeNode(15);
        no1.left = no2;no1.right = no3;
        no2.left = no4;no2.right = no5;
        no3.left = no6;no3.right = no7;
        no4.left = no8;no4.right = no9;
        no5.left = no10;no5.right = no11;
        no6.left = no12;no6.right = no13;
        no7.left = no14;no7.right = no15;

        System.out.println(connect(no1));
    }

    /**
     * 满二叉树的求next指针
     * @param root
     * @return
     */
    public static TreeNode connect(TreeNode root) {
        if(root == null) return root;
        TreeNode head = root;
        while (head.left != null) {
            TreeNode prev = head;
            while (prev != null) {
                prev.left.next = prev.right;
                prev.right.next = prev.next != null ? prev.next.left : null;
                prev = prev.next;
            }
            head = head.left;
        }
        return root;
    }


    /**
     * 非满二叉树的求next指针
     * @param root
     * @return
     */
    public static TreeNode connect2(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        return root;
    }



    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ",\n left=" + left +
                    ",\n right=" + right +
                    ",\n next=" + (next == null ? "null" : next.val) +
                    '}';
        }
    }
    
}
