package com.justin.algorithm.tree;


import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 树型DP
 * 1、判断一棵树是否是平衡二叉树
 * 2、判断一个二叉树是否是满二叉树
 * 3、获取二叉树中两个节点的公共最小节点
 * 4、二叉树的序列化、反序列化
 */
public class Learn2 {

    public static void main(String[] args) {
        /**
         *  *                      1
         *  *                   /    \
         *  *                 /       \
         *  *               /          \
         *  *              /            \
         *  *             2               3
         *  *          /    \           /   \
         *  *        4       5         6      7
         *  *      /  \    /  \      /  \   /   \
         *  *     8   9   10  11    12  13 14   15
         */
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

        System.out.println("判断是否是满二叉树 => "+ isF(node1));
        System.out.println("判断是否是平衡二叉树 =>" + isBST(node1));

        TreeNode no1 = node8;
        TreeNode no2 = node9;
        System.out.println("节点一:" + no1.val + "与节点二:" + no2.val + "的最近公共父节点:" + getParentNode(node1, no1, no2) == null ? "null" : getParentNode(node1, no1, no2).val);
        System.out.println("节点一:" + no1.val + "与节点二:" + no2.val + "的最近公共父节点:" + getParentNode2(node1, no1, no2) == null ? "null" : getParentNode2(node1, no1, no2).val);

        System.out.println("序列化结果:" + toString2(node1));
    }

    /**
     * 将二叉树序列化
     * @param node
     * @return
     */
    private static String toString2(TreeNode node) {
        if(node == null) return "#_";
        String result = toString2(node.left);
        result = result + node.val + "_";
        String rightResult = toString2(node.right);
        return result + rightResult;
    }

    /**
     * 将二叉树序列化的字符串生成完整二叉树
     * @param str
     * @return
     */
    private static TreeNode toTreeNode(String str) {
        TreeNode node = new TreeNode(1);
        String[] arr = str.split("_");


        return node;
    }

    /**
     * 通过递归查找最近公共父节点
     * @param heed
     * @param node1
     * @param node2
     * @return
     */
    private static TreeNode getParentNode2(TreeNode heed, TreeNode node1, TreeNode node2) {
        if(heed == null || heed == node1 || heed == node2) return heed;
        // 在左树中找node1、node2
        TreeNode leftNode = getParentNode2(heed.left, node1, node2);
        // 在右树中找node1、node2
        TreeNode rightNode = getParentNode2(heed.right, node1, node2);
        if(leftNode != null && rightNode != null) {
          // 当左右节点都不为空，说明node1、node2分别位于当前节点的左、右子树中
            return heed;
        }
        return leftNode == null ? rightNode : leftNode;
    }

    /**
     * 获取两个节点的公共父节点
     * @param heed: 二叉树的首节点
     * @param node1：第一个已知节点
     * @param node2：第二哥已知节点
     * @return
     */
    private static TreeNode getParentNode(TreeNode heed, TreeNode node1, TreeNode node2) {
        if(heed == null) return null;
        // 记录每个节点的父节点的map
        HashMap<TreeNode, TreeNode>parentMap = new HashMap<>();
        flatParentMap(parentMap, heed, heed);
        HashSet<TreeNode> node1AllParentSet = new HashSet<>();
        TreeNode currentNode = node1;
        node1AllParentSet.add(currentNode);
        TreeNode prevNode;
        while ((prevNode = parentMap.get(currentNode))  != currentNode) {
            // 当从node1节点往上取获取父节点
            node1AllParentSet.add(prevNode);
            currentNode = prevNode;
        }
        currentNode = node2;
        while ((prevNode = parentMap.get(currentNode)) != currentNode) {
            if(node1AllParentSet.contains(currentNode)) {
                return currentNode;
            }
            currentNode = prevNode;
        }

        return heed;
    }

    /**
     * 将每个节点与它的父节点关联
     * @param parentMap
     * @param node
     */
    static void flatParentMap(HashMap<TreeNode, TreeNode> parentMap, TreeNode node, TreeNode parent) {
        if(node == null) return;
        parentMap.put(node, parent);
        flatParentMap(parentMap, node.left, node);
        flatParentMap(parentMap, node.right, node);
    }


    /**
     * 判断是否是平衡二叉树
     * @param node
     * @return
     */
    private static boolean isBST(TreeNode node) {
        BSTReturnType result = process2(node);
        return result.isBST;
    }

    private static BSTReturnType process2(TreeNode node) {
        if(node == null) return new BSTReturnType(true, 0);
        BSTReturnType leftData = process2(node.left);
        BSTReturnType rightData = process2(node.right);
        boolean isBST = false;
        int maxHeight = Math.max(leftData.height, rightData.height);
        int minHeight = Math.min(leftData.height, rightData.height);
        if(maxHeight - minHeight <= 1 && leftData.isBST && rightData.isBST) isBST = true;
        return new BSTReturnType(isBST, maxHeight + 1);
    }


    private static class BSTReturnType {
        boolean isBST;
        int height;

        public BSTReturnType(boolean i, int h) {
            isBST = i;
            height = h;
        }
    }

    /**
     *
     * @param node
     * @return
     */
    private static boolean isF(TreeNode node) {
       FReturnType all = process(node);
        return all.count == Math.pow(2, all.height) - 1;
    }

    private static FReturnType process(TreeNode node) {
        if(node == null) return new FReturnType(0, 0);
        FReturnType leftData = process(node.left);
        FReturnType rightData = process(node.right);
        return new FReturnType(leftData.count + rightData.count + 1,Math.max(leftData.height, rightData.height) + 1);
    }

    private static class FReturnType {
        int count;
        int height;

        public FReturnType(int c, int h) {
            count = c;
            height = h;
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
