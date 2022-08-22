package com.justin.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 图的数据结构
 */
public class Graph {
    // 图中涉及到的所有的节点
    public ArrayList<GraphNode> nodes;
    // 图中涉及到的所有的边
    public ArrayList<GraphEdge> edges;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }

    public static void main(String[] args) {
        /**
         * 二维数组(矩阵)M描述图，Mi标识的是一条由两个节点组成的线段
         * Mi0:起始节点
         * Mi1:终止节点
         * Mi2:线段比重
         * [
         *  [1,2,100],
         *  [1,3,50],
         *  [2,3,70],
         *  [2,4,60],
         *  [3,4,1000],
         *  [4,5,10000],
         *  [5,6,600000],
         * ]
         */
        List<List<Integer>>lists = new ArrayList<>();
        lists.add(Arrays.asList(1,2,100));
        lists.add(Arrays.asList(1,3,50));
        lists.add(Arrays.asList(2,3,70));
        lists.add(Arrays.asList(2,4,60));
        lists.add(Arrays.asList(3,4,1000));
        lists.add(Arrays.asList(4,5,10000));
        lists.add(Arrays.asList(5,6,600000));

        Graph graph = toGraph(lists);
        System.out.println("Result:" + graph.toString());
    }

    /**
     * 将一个使用二维数组描述的图改造成Graph的数据格式
     * @param lists
     * @return
     */
    public static Graph toGraph(List<List<Integer>>lists) {
        if (lists == null) return null;
        Graph graph = new Graph();
        HashSet<Integer> nodeSet = new HashSet<>();
        HashMap<Integer, Integer>nodeMap = new HashMap<>();

        for(List<Integer> list : lists) {
            // 遍历二维数组，取到每条线段
            // 取到起点、终点编号
            int startNodeCode = list.get(0);
            int endNodeCode = list.get(1);
            GraphNode fromNode, toNode;
            // 当不包含起点编号时，说明这是一个新节点，需要插入进去
            if(!nodeMap.containsKey(startNodeCode)) {
                fromNode = new GraphNode(startNodeCode);
                graph.nodes.add(fromNode);
                fromNode.out ++;
                // 将节点加入到graph后，记录在数组中的下标位置，便于找回
                nodeMap.put(startNodeCode, graph.nodes.size());
            } else {
                // 当不是新节点，因为是起点，所以需要更新出度 + 1
                fromNode = graph.nodes.get(nodeMap.get(startNodeCode) - 1);
                fromNode.out ++;
            }
            // 同理处理线段终点
            if(!nodeMap.containsKey(endNodeCode)) {
                toNode = new GraphNode(endNodeCode);
                graph.nodes.add(toNode);
                toNode.in ++;
                nodeMap.put(endNodeCode, graph.nodes.size());
            } else {
                // 当不是新节点，因为是终点，所以需要更新入读 + 1
                toNode = graph.nodes.get(nodeMap.get(endNodeCode) - 1);
                toNode.in ++;
            }
            fromNode.next.add(toNode);
            // 再处理线段, 因为每条数据就代表一条线段，所以线段数据肯定是新的
            GraphEdge edge = new GraphEdge(fromNode, toNode, list.get(2));
            graph.edges.add(edge);
        }

        return graph;
    }


}
