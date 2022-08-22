package com.justin.algorithm.graph;

/**
 * 图中的边，连接两个节点的
 */
public class GraphEdge {
    // 边的起点
    public GraphNode from;
    // 边的终点
    public GraphNode to;
    // 边的比重，如表示两点的距离
    public int weight;
    public GraphEdge(GraphNode f, GraphNode t, int w) {
        from = f;
        to = t;
        weight = w;
    }

    @Override
    public String toString() {
        return "GraphEdge{" +
                "from=" + from.val +
                ", to=" + to.val +
                ", weight=" + weight +
                '}';
    }
}
