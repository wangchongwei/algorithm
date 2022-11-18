package com.justin.algorithm.tree;


/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */
public class Solution114 {

    public static void main(String[] args) {
        TreeNode no1 = new TreeNode(1);
        TreeNode no2 = new TreeNode(2);
        TreeNode no5 = new TreeNode(5);
        TreeNode no3 = new TreeNode(3);
        TreeNode no4 = new TreeNode(4);
        TreeNode no6 = new TreeNode(6);
        no1.left = no2;no1.right = no5;
        no2.left = no3;no2.right = no4;
        no5.right = no6;
//        flatten(no1);
//        System.out.println(head);
        flatten2(no1);
    }

    static TreeNode currntNode;
    static TreeNode head;
    /**
     * 先序遍历 空间复杂度O(n)
     * @param root
     */
    public static void flatten(TreeNode root) {
        if(root == null) return;
        if(currntNode == null) {
            currntNode = new TreeNode(root.val);
            head = currntNode;
        } else {
            currntNode.right = new TreeNode(root.val);
            currntNode = currntNode.right;
        }
        flatten(root.left);
        flatten(root.right);
    }

    static TreeNode leftNode, rightNode;
    /**
     * 要求原地算法，空间复杂度为O(1)
     * @param root
     */
    public static void flatten2(TreeNode root) {
        TreeNode curr = root;
        TreeNode node = curr;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
        System.out.println("node =>" + node);
    }

    /**
     * 将右侧的节点设置在左节点的最右子节点
     * @param leftNode
     * @param rightNode
     */
    private static void setLeftLast(TreeNode leftNode, TreeNode rightNode) {
        if(rightNode == null) return;
        if(leftNode == null) return;
        setLeftLast(leftNode.left, rightNode);
        setLeftLast(leftNode.right,rightNode);
        
    }

    public static TreeNode process(TreeNode root) {
        if(root == null) return null;

        TreeNode left = process(root.left);
        TreeNode right = process(root.right);
        return root;
    }



    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int v) {
            val = v;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
