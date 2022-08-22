package com.justin.algorithm.tree;


/**
 * 给点一个特定节点，
 * 查找其后继节点（后继节点，指中序遍历中的后一个位置的节点）
 */
public class Learn3 {

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

        node1.left = node2;node1.right = node3;node1.parent = null;
        node2.left = node4;node2.right = node5;node2.parent = node1;
        node3.left = node6;node3.right = node7;node3.parent = node1;
        node4.left = node8;node4.right = node9;node4.parent = node2;
        node5.left = node10;node5.right = node11;node5.parent = node2;
        node6.left = node12;node6.right = node13;node6.parent = node3;
        node7.left = node14;node7.right = node15;node7.parent = node3;

        node8.parent = node4; node9.parent = node4;
        node10.parent = node5; node11.parent = node5;
        node12.parent = node6; node13.parent = node6;
        node14.parent = node7; node15.parent = node7;

        TreeNode node = node7;
        System.out.println("当前节点：" + node.value + "的后继节点" + (getNextNode(node) == null ? "null" : getNextNode(node).value));
    }


    private static TreeNode getNextNode(TreeNode node) {
        if(node == null) return null;
        TreeNode resultNode = node;
        if(resultNode.right != null) {
            // 如果节点的右子树不为空，则下一个节点一定为右子树中的左节点
            resultNode = resultNode.right;
            while (resultNode.left != null) {
                resultNode = resultNode.left;
            }
        } else {
            // 右子树为空的话，判断该节点是否是父节点的右节点
            while (resultNode.parent != null && resultNode.parent.left != resultNode) {
                // 说明该节点是右节点，则需要向上找祖父节点
                resultNode = resultNode.parent;
                if(resultNode.parent == null)break;
            }
            resultNode = resultNode.parent;
        }
        return resultNode;
    }

    private static TreeNode getNextNode2(TreeNode node) {
        if(node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
        } else {
            while (node.parent.left != node) {
                node = node.parent;
                if(node.parent == null) break;
            }
            node = node.parent;
        }
        return node;
    }


    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int v) {
            value = v;
        }
    }
}
