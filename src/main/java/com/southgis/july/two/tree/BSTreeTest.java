package com.southgis.july.two.tree;

/**
 * @author 王军
 * @description
 * @date 2021/7/2 11:52
 */
public class BSTreeTest {
    public static void main(String[] args) {
        BSTree<Integer> bsTree = new BSTree<>();
        bsTree.insert(10);
        bsTree.insert(5);
        bsTree.insert(15);
        bsTree.insert(6);
        bsTree.insert(4);
        bsTree.insert(16);
        bsTree.preOrder();
        System.out.println("\n");
        System.out.println("两种查询");
        System.out.println(bsTree.search(16));
        System.out.println(bsTree.search(15));
        System.out.println(bsTree.minimum());
        System.out.println(bsTree.maximum());

        System.out.println("\n");
        System.out.println("右孩子无左节点节点前驱");
        System.out.println(bsTree.predecessor(bsTree.search(15)));
        System.out.println("左孩子无左节点节点前驱");
        System.out.println(bsTree.predecessor(bsTree.search(4)));
        System.out.println("有左节点节点前驱");
        System.out.println(bsTree.predecessor(bsTree.search(10)));

        System.out.println("\n");
        System.out.println("右孩子无右节点节点后驱");
        System.out.println(bsTree.successor(bsTree.search(15)));
        System.out.println("左孩子无右节点节点后驱");
        System.out.println(bsTree.successor(bsTree.search(4)));
        System.out.println("有右节点节点后驱");
        System.out.println(bsTree.successor(bsTree.search(10)));

        bsTree.print();

        System.out.println("\n");
        bsTree.remove(15);
        bsTree.print();

        System.out.println("\n");
        bsTree.remove(5);
        bsTree.print();

    }
}