package com.justin.algorithm.tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * bilibili学习
 * 二叉树 递归、非递归先序、中序、后序遍历
 *                      1
 *                   /    \
 *                 /       \
 *               /          \
 *              /            \
 *             2               3
 *          /    \           /   \
 *        4       5         6      7
 *      /  \    /  \      /  \   /   \
 *     8   9   10  11    12  13 14   15
 */
public class Learn1 {



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);

        node1.left = node2;node1.right = node3;
        node2.left = node4;node2.right = node5;
        node3.left = node6;node3.right = node7;
        node4.left = node8;node4.right = node9;
        node5.left = node10;node5.right = node11;
        node6.left = node12;node6.right = node13;
        node7.left = node14;node7.right = node15;

//        firstSort(node1);
//        middleSort(node1);
//        afterSort(node1);

//        firstSort2(node1);
//        middleSort2(node1);

//        sort(node1);
        sort2(node1);
    }





    // 递归先序遍历 头左右
    public static void firstSort(TreeNode node) {
        if(node == null) return;
        System.out.println("nodeValue:" + node.val);
        firstSort(node.left);
        firstSort(node.right);
    }

    // 递归中序遍历 左中头
    public static void middleSort(TreeNode node) {
        if(node == null) return;
        middleSort(node.left);
        System.out.println("nodeValue:" + node.val);
        middleSort(node.right);
    }

    // 递归后序遍历 左右头
    public static void afterSort(TreeNode node) {
        if(node == null) return;
        afterSort(node.left);
        afterSort(node.right);
        System.out.println("nodeValue:" + node.val);
    }


    /**
     * 非递归先序遍历 头左右
     * 采用非递归方式时，需要借助额外的数据结构，此处是栈
     * @param node
     */
    public static void firstSort2(TreeNode node) {
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.empty()) {
            TreeNode currentNode = stack.pop();
            System.out.println("nodeValue: " + currentNode.val);
            if(currentNode.right != null) {
                stack.add(currentNode.right);
            }
            if(currentNode.left != null) {
                stack.add(currentNode.left);
            }
        }
    }

    /**
     * 非递归中序遍历 左右头
     */
    public static void middleSort2(TreeNode node) {
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = node;
        while (!stack.empty() || currentNode != null) {
            if(currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode prev = stack.pop();
                System.out.println("nodeValue: " + prev.val);
                currentNode = prev.right;
            }
        }
    }

    /**
     * 非递归后序遍历 左右头
     * 借助两个栈来实现
     * @param node
     */
    public static void afterSort2(TreeNode node) {
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = node;
        while (currentNode != null || !stack.empty()) {

        }
    }

    /**
     * 宽度优先遍历
     * 需要借助队列
     * @param node
     *
     */
    public static void sort(TreeNode node) {
        if(node == null) return;
        // 双向链表做队列
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.println("nodeValue: " + currentNode.val);
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    /**
     * 宽度优先遍历，并统计最宽的层级节点数量
     * 在宽度优先遍历算法基础上进行修改
     * @param node
     */
    public static int sort2(TreeNode node) {
        if(node == null) return 0;

        // 双向链表做队列
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(node);
        int currentLevel = 1; // 当前层级
        int max = 1; // 层级节点数最大值
        int currentLevelCount = 0; // 层级节点数
        HashMap<TreeNode, Integer>map = new HashMap(); // 记录每个节点的所属层级
        map.put(node, 1);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if(currentLevel == map.get(currentNode)) {
                // 属于当前层级
                currentLevelCount ++;
            } else {
                // 需要切换层级
                currentLevel ++;
                max = Math.max(max, currentLevelCount);
                currentLevelCount = 1;
            }
            System.out.println("nodeValue: " + currentNode.val);
            System.out.println("currentLevel:" + currentLevel);
            System.out.println("currentLevelCount:" + currentLevelCount);
            if(currentNode.left != null) {
                queue.add(currentNode.left);
                map.put(currentNode.left, currentLevel + 1);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
                map.put(currentNode.right, currentLevel + 1);
            }
        }
        max = Math.max(max, currentLevelCount);
        System.out.println("max:" + max);
        return max;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
