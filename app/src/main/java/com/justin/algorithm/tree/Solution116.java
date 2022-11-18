package com.justin.algorithm.tree;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 进阶：
 *
 * * 你只能使用常量级额外空间。
 * * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Solution116 {


    public static void main(String[] args) {
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
        System.out.println("result:" + connect2(no1));
    }

    /**
     * 通过广度优先遍历，给节点添加next
     * @param root
     * @return
     */
    public static TreeNode connect(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode head = root;
        head.next = null;
        int level = 1;
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(root,level);
        TreeNode lastRight = null;
        while (!queue.isEmpty()) {
            TreeNode prev = queue.poll();
            System.out.println("val:" + prev.val);
            TreeNode left = prev.left;
            TreeNode right = prev.right;
            if(levelMap.get(prev) != level) {
                // 换层
                level ++;
                lastRight = null;
                if(left != null) {
                    right.next = null;
                }
            } else if(left != null && lastRight != null) {
                lastRight.next = left;
            }
            if(left == null) continue;
            queue.add(left);
            queue.add(right);
            left.next = right;
            levelMap.put(left, level+1);
            levelMap.put(right, level+1);
            lastRight = right;
        }
        return root;
    }


    /**
     * 进阶 空间复杂度O(1)
     *  * 你只能使用常量级额外空间。
     *  * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     * @param root
     * @return
     */
    public static TreeNode connect2(TreeNode root) {
        if(root == null) return root;
        if(root.left!=null){
            root.left.next=root.right;
            root.right.next=root.next!=null?root.next.left:null;
            connect2(root.left);
            connect2(root.right);
        }
        return root;
    }

    public static TreeNode connect3(TreeNode root) {
        if (root == null) return root;

        // 从根节点开始
        TreeNode leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            TreeNode head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
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


