package com.southgis.book.grokkingAlgorithms.graph;

/**
 * @author 王军
 * @description 图的搜索
 * @date 2021/6/17 16:27
 */
public class GraphSearch {

    /***
     *
     * 广度优先遍历搜索
     * 找不到返回null 找到返回节点
     * @param node 查找的起点
     * @param data 查找的数据
     * @return GraphNode<T>
     */
    public static <T> String getGraphBFSPath(GraphNode<T> node, T data) {
        StringBuffer searchPathBFS = new StringBuffer();

        Queue<GraphNode<T>> queue = new Queue<>();
        node.setVisited(true);
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            GraphNode<T> graphNode = queue.dequeue();
            searchPathBFS.append(graphNode.data);
            if (graphNode.data == data) {
                break;
            } else {
                searchPathBFS.append("->");
                for (GraphNode<T> tGraphNode : graphNode.neighborList) {
                    if (!tGraphNode.isVisited()) {
                        tGraphNode.setVisited(true);
                        queue.enqueue(tGraphNode);
                    }
                }
            }
        }
        return searchPathBFS.toString();
    }

    /***
     *
     * 广度优先遍历搜索
     * 找不到返回null 找到返回节点
     * @param node 查找的起点
     * @param data 查找的数据
     * @return GraphNode<T>
     */
    public static <T> GraphNode<T> breadthFirstTraversalSearch(GraphNode<T> node, T data) {
        GraphNode<T> findNode = null;
        Queue<GraphNode<T>> queue = new Queue<>();
        node.setVisited(true);
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            GraphNode<T> graphNode = queue.dequeue();
            if (graphNode.data == data) {
                findNode = graphNode;
                break;
            } else {
                for (GraphNode<T> tGraphNode : graphNode.neighborList) {
                    if (!tGraphNode.isVisited()) {
                        tGraphNode.setVisited(true);
                        queue.enqueue(tGraphNode);
                    }
                }
            }
        }
        return findNode;
    }
}