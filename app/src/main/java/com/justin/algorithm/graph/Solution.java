package com.justin.algorithm.graph;


import com.justin.algorithm.tree.Learn1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 1、图广度优先算法
 * 借助队列
 *
 * 2、图深度优先算法
 * 借助栈
 *
 * 3、拓扑图算法
 *
 * 4、Kruskal算法
 *
 * 5、Prim 算法
 *
 * 6、并列集算法
 */
public class Solution {

    public static void main(String[] args) {
        // 使用二维数组描述图
        List<List<Integer>>lists = new ArrayList<>();
        lists.add(Arrays.asList(1,2,100));
        lists.add(Arrays.asList(1,3,50));
        lists.add(Arrays.asList(2,3,70));
        lists.add(Arrays.asList(2,4,60));
        lists.add(Arrays.asList(3,4,1000));
        lists.add(Arrays.asList(4,5,10000));
        lists.add(Arrays.asList(5,6,600000));
        // 再将二维数组转换为自己的类Graph
        Graph graph = Graph.toGraph(lists);
        System.out.println("graph.nodes =>" + graph.nodes);
//        process(graph.nodes.get(0));
//        process2(graph.nodes.get(0));
        process3(graph);
    }

    // 广度优先遍历
    private static void process(GraphNode node) {
        if(node == null) return;
        Queue<GraphNode> queue = new LinkedList<>();
        HashSet<GraphNode>set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.poll();
            System.out.println("val:" + currentNode.val);
            for(GraphNode no: currentNode.next) {
                // 取出下一层的节点
                if(!set.contains(no)) {
                    queue.add(no);
                    set.add(no);
                }
            }
        }
    }


    /**
     * 深度优先遍历
     * @param node
     */
    private static void process2(GraphNode node) {
        if(node == null) return;
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        while (!stack.empty()) {
            GraphNode currentNo = stack.pop();
            System.out.println("val: " + currentNo.val);
            for(GraphNode no : currentNo.next) {
                if(!set.contains(no)) {
                    // 无时，添加
                    set.add(no);
                    stack.add(currentNo);
                    stack.add(no);
                    break;
                }
            }
        }
    }

    /**
     * 拓扑图算法
     * 可以变种为循环依赖的
     * 解决思路，先找入度为0的，然后去掉入度为0节点，再去除入度为0节点造成其他节点的入读影响，再去除入读0节点。
     * 循环往复，得出一个节点顺序即可。
     * @param graph
     */
    private static void process3(Graph graph) {
        if(graph == null) return;
        // 入度为0时，才能进入队列
        Queue<GraphNode>queue = new LinkedList<>();
        // 记录每个节点的入读
        HashMap<GraphNode, Integer>inMap = new HashMap<>();
        for(GraphNode node : graph.nodes) {
            // 初始化inMap、queue的数据
            inMap.put(node, node.in);
            if(node.in == 0) {
                queue.add(node);
            }
        }
        System.out.println("in == 0 => " + queue);
        // 拓扑排序的结果
        List<GraphNode> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            System.out.println("queue.poll: " + node);
            result.add(node);
            for(GraphNode no: node.next) {
                inMap.put(no, inMap.get(no) - 1);
                if(inMap.get(no) <= 0) {
                    // 当有新节点的入度为0， 添加到队列
                    queue.add(no);
                }
            }
        }
        System.out.println("result: " + result);
    }

}
