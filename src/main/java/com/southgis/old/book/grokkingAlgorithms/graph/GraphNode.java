package com.southgis.book.grokkingAlgorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王军
 * @description 图
 * @date 2021/6/16 20:19
 */
public class GraphNode<T> {
    T data;
    List<GraphNode<T>> neighborList;
    /**
     * 标记这个节点有木有被访问过
     * 广度优先遍历遍历时没有访问才会把其邻居加入队列中
     */
    private boolean visited;


    public GraphNode(T data) {
        this.data = data;
        this.neighborList = new ArrayList<>();
        this.visited = false;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "data=" + data +
                '}';
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }


    /**
     * 还原图中所有节点为未访问
     */
    public void restoreVisited(){
        restoreVisited(this);
    }

    /**
     * 还原node的图所有节点为未访问
     * @param node
     */
    private void restoreVisited(GraphNode<T> node){
        //图构成循环会死循环
        //仅适用于没有环的图
        if(node.visited){
            node.visited = false;
        }

        List<GraphNode<T>> neighbors = node.neighborList;
        for (GraphNode<T> neighbor : neighbors) {
            restoreVisited(neighbor);
        }

    }
}