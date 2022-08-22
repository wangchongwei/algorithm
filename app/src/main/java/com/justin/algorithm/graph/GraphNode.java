package com.justin.algorithm.graph;

import java.util.ArrayList;

/**
 * 图中的节点类
 *
 * A        B
 *  ↘️    ↙️
 *     C
 */
public class GraphNode {
    // 点的编号
    public int val;
    // 输入的度 如上所示 C的输入的度为2，A、B输入的度为0
    public int in;
    // 输出的度 如上所示 A、B输出的度是1，C输出的度是0
    public int out;
    // 指向输出的节点 如A、B输出的节点都是C，而C输出的节点是空
    public ArrayList<GraphNode>next;

    public GraphNode(int v) {
        val = v;
        in = 0;
        out = 0;
        next = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "val=" + val +
                ", in=" + in +
                ", out=" + out +
                ", next=" + next.size() +
                '}';
    }
}
