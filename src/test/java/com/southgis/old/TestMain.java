package com.southgis.old;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TestMain {
    @Test
    public void testArrayList() {
        List<Integer> list = new ArrayList<Integer>(8);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }

    @Test()
    public void testVector() {
        List<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        System.out.println(vector);
    }
}
