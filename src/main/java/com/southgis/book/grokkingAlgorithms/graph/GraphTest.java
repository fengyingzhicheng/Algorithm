package com.southgis.book.grokkingAlgorithms.graph;

import org.junit.Before;
import org.junit.Test;

/**
 * @author 王军
 * @description 构造图并搜索
 * @date 2021/6/16 20:47
 */
public class GraphTest {
    GraphNode<String> node1;
    GraphNode<String> node2;
    GraphNode<String> node3;
    GraphNode<String> node4;
    GraphNode<String> node5;
    GraphNode<String> node6;


    @Before
    public void generateGraph() {
        node1 = new GraphNode<>("A");
        node2 = new GraphNode<>("B");
        node3 = new GraphNode<>("C");
        node4 = new GraphNode<>("D");
        node5 = new GraphNode<>("E");
        node6 = new GraphNode<>("F");

        node1.neighborList.add(node2);
        node1.neighborList.add(node3);
        node1.neighborList.add(node4);

        node2.neighborList.add(node3);
        node2.neighborList.add(node4);

        node3.neighborList.add(node4);
        node3.neighborList.add(node5);

        node4.neighborList.add(node5);
        node4.neighborList.add(node6);

    }

    @Test
    public void breadthFirstSearch() {
        System.out.println(GraphSearch.breadthFirstTraversalSearch(node1, "E"));
        System.out.println(GraphSearch.getGraphBFSPath(node1, "E"));

    }
}