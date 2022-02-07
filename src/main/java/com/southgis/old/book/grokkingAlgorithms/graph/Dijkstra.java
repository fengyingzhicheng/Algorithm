package com.southgis.book.grokkingAlgorithms.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王军
 * @description 狄克斯特拉算法
 * @date 2021/6/18 10:28
 */
public class Dijkstra {
    Map<String,Map<String,Integer>> map=new HashMap<>();

    /**
     *获取最小距离
     *
     * @param start 起始位置
     * @param end 终点位置
     * @param graph 记录有权图的信息
     * @return String
     */
    public String getTheMinimumDistance(String start, String end, Map<String,Map<String,Integer>> graph) {
        StringBuilder stringBuilder=new StringBuilder();

        return stringBuilder.toString();
    }


    @Before
    public void generateWeightGraph() {
        Map<String,Integer> weight=new HashMap<>();
        weight.put("B",1);
        weight.put("C",1);
        map.put("A",weight);

        Map<String,Integer> map1=new HashMap<>();
        map1.put("D",2);
        map.put("B",map1);

        Map<String,Integer> map2=new HashMap<>();
        map2.put("D",1);
        map.put("C",map2);

        Map<String,Integer> map3=new HashMap<>();
        map3.put("E",3);
        map3.put("F",2);
        map.put("D",map3);

        Map<String,Integer> map4=new HashMap<>();
        map4.put("F",4);
        map.put("E",map4);
    }

    @Test
    public void testDijkstra() {
        System.out.println(getTheMinimumDistance("A","F",map));
    }
}