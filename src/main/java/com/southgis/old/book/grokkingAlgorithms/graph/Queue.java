package com.southgis.book.grokkingAlgorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王军
 * @description 队列
 * @date 2021/6/16 20:11
 */
public class Queue<T> {
    private final List<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(T data) {
        list.add(data);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return list.remove(0);
    }

    public List<T> getList() {
        return list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}