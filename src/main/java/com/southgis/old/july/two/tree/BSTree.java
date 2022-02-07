package com.southgis.old.july.two.tree;

import lombok.NonNull;
import lombok.ToString;

/**
 * @author 王军
 * 名词：
 * 节点的前驱: "二叉树中数据值小于该结点"的"最大结点"
 * 节点的后继: "二叉树中数据值大于该结点"的"最小结点"。
 * <p>
 * 功能：
 * 实现二叉树的前序中序后序遍历
 * 实现二叉查找树中的查找（递归，非递归）、插入值成节点、最大值、最小值
 * 实现二叉查找树根据节点查找前驱，后驱
 * @description
 * @date 2021/7/2 11:10
 */
public class BSTree<T extends Comparable<T>> {
    BSTNode<T> mRoot;

    @ToString(exclude = "parent")
    public static class BSTNode<T extends Comparable<T>> {
        BSTNode<T> left;
        BSTNode<T> right;
        BSTNode<T> parent;
        T key;

        public BSTNode(BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent, T key) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.key = key;
        }
    }

    /***
     *
     * 前序遍历树
     *
     *
     */
    public void preOrder() {
        preOrder(mRoot);
    }

    /***
     *
     * 每个节点前序遍历
     * @param treeNode 遍历的节点
     *
     */
    private void preOrder(BSTNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.key);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /***
     *
     * 中序遍历
     *
     *
     */
    public void inOrder() {
        inOrder(mRoot);
    }

    /***
     *
     * 中序遍历每个节点
     * @param treeNode 当前节点
     *
     */
    private void inOrder(BSTNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode.key);
        inOrder(treeNode.right);
    }

    /***
     *
     * 后序遍历
     *
     *
     */
    public void postOrder() {
        postOrder(mRoot);
    }

    /***
     *
     * 后续遍历每个节点
     * @param treeNode 当前节点
     *
     */
    private void postOrder(BSTNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.key);
    }

    /**
     * 二叉树查找
     *
     * @param key 查找的值
     * @return BSTree<BSTNode < T>
     */
    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    /***
     *
     * 递归方式二分查找
     * @param bstNode 节点
     * @param key 查找的值
     * @return BSTree<BSTNode < T>
     */
    private BSTNode<T> search(BSTNode<T> bstNode, T key) {
        if (bstNode == null) {
            return bstNode;
        }
        int cmp = key.compareTo(bstNode.key);
        if (cmp < 0) {
            return search(bstNode.left, key);
        } else if (cmp > 0) {
            return search(bstNode.right, key);
        } else {
            return bstNode;
        }
    }


    /***
     *
     * (非递归实现)查找"二叉树x"中键值为key的节点
     * @param bstNode 节点
     * @param key 查找值
     * @return BSTree<BSTNode < T>
     */
    private BSTNode<T> iterativeSearch(BSTNode<T> bstNode, T key) {
        while (bstNode != null) {
            int cmp = key.compareTo(bstNode.key);

            if (cmp < 0) {
                bstNode = bstNode.left;
            } else if (cmp > 0) {
                bstNode = bstNode.right;
            } else {
                return bstNode;
            }
        }

        return bstNode;
    }

    /***
     *
     * 非递归查找某个值
     * @param key 查找值
     * @return BSTree<BSTNode < T>
     */
    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /**
     * 二叉树插入
     *
     * @param key 查找的值
     */
    public void insert(T key) {
        BSTNode<T> bstNode = new BSTNode<T>(null, null, null, key);
        insert(this, bstNode);
    }

    /***
     *
     * 将节点插入树中
     * @param tree 树
     * @param bstNode 节点
     *
     */
    private void insert(BSTree<T> tree, BSTNode<T> bstNode) {
        if (tree.mRoot == null) {
            mRoot = bstNode;
            return;
        }
        //指向当前遍历中在比较的节点
        BSTNode<T> local = mRoot;
        while (true) {
            int cmp = bstNode.key.compareTo(local.key);
            if (cmp < 0) {
                if (local.left == null) {
                    local.left = bstNode;
                    bstNode.parent = local;
                    break;
                }
                local = local.left;

            } else {
                if (local.right == null) {
                    local.right = bstNode;
                    bstNode.parent = local;
                    break;
                }
                local = local.right;
            }
        }
    }

    /***
     *
     * 找到二叉查找树的最大值所在节点（特征 最大值在最右下角）
     * @param root 树
     * @return BSTNode<T>
     */
    public BSTNode<T> maximum(BSTNode<T> root) {
        BSTNode<T> local = root;
        while (local != null && local.right != null) {
            local = local.right;
        }
        return local;
    }

    /***
     *
     * 返回树中的最大值
     *
     * @return T
     */
    public T maximum() {
        BSTNode<T> bstNode = maximum(mRoot);
        return bstNode != null ? bstNode.key : null;
    }

    /***
     *
     * 找到二叉查找树的最小值所在节点（特征 最小值在最右下角）
     * @param root 树
     * @return BSTNode<T>
     */
    public BSTNode<T> minimum(BSTNode<T> root) {
        BSTNode<T> local = root;
        while (local != null && local.left != null) {
            local = local.left;
        }
        return local;
    }

    /***
     *
     * 返回树中的最大值
     *
     * @return T
     */
    public T minimum() {
        BSTNode<T> bstNode = minimum(mRoot);
        return bstNode != null ? bstNode.key : null;
    }

    /***
     * 前驱节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的前一个节点为该节点的前驱节点；
     * 节点的前驱: "二叉树中数据值小于该结点"的"最大结点"
     * 查找一个节点的前驱
     * @param node 查找的节点
     * @return BSTNode<T>
     */
    public BSTNode<T> predecessor(@NonNull BSTNode<T> node) {
        //左子树中的最大节点。
        if (node.left != null) {
            return maximum(node.left);
        }


        // 如果node没有左孩子。则node有以下两种可能:
        // (01) node是"一个右孩子"，则"node的前驱结点"为 "它的父结点"。
        // (01) node是"一个左孩子"，则查找"node的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"node的前驱结点"。
        BSTNode<T> firstParent = node.parent;

        //右孩子直接返回了
        while ((firstParent != null) && (node == firstParent.left)) {
            //往上找 找到某个节点是其父节点的右节点跳出 这个父节点就是
            node = firstParent;
            firstParent = firstParent.parent;
        }

        return firstParent;
    }

    /***
     * 节点的后继: "二叉树中数据值大于该结点"的"最小结点"。
     * 后继节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的后一个节点为该节点的后继节点；
     * 查找一个节点的后继
     * @param node 查找的节点
     * @return BSTNode<T>
     */
    public BSTNode<T> successor(@NonNull BSTNode<T> node) {

        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (node.right != null) {
            return minimum(node.right);
        }

        // 如果node没有右孩子。则node有以下两种可能:
        // (01) node是"一个左孩子"，则"node的后继结点"为 "它的父结点"。
        // (02) node是"一个右孩子"，则查找"node的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"node的后继结点"。
        BSTNode<T> firstParent = node.parent;
        while ((firstParent != null) && (node == firstParent.right)) {
            node = firstParent;
            firstParent = firstParent.parent;
        }

        return firstParent;
    }


    /***
     *
     * 打印"二叉查找树"
     * @param node 节点
     * @param key 值
     * @param direction 方向
     *  0，表示该节点是根节点;
     *  -1，表示该节点是它的父结点的左孩子;
     *  1，表示该节点是它的父结点的右孩子。
     */
    private void print(BSTNode<T> node, T key, int direction) {

        if (node != null) {

            // tree是根节点
            if (direction == 0) {
                System.out.printf("%2d is root\n", node.key);
                // tree是分支节点
            } else {
                System.out.printf("%2d is %2d's %6s child\n", node.key, key, direction == 1 ? "right" : "left");
            }

            print(node.left, node.key, -1);
            print(node.right, node.key, 1);
        }
    }

    /***
     *
     * 打印结点信息
     *
     *
     */
    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }


    /***
     *
     * 销毁节点
     * @param bstNode 要销毁的树根节点
     *
     */
    private void destroy(BSTNode<T> bstNode) {
        if (bstNode == null) {
            return;
        }

        if (bstNode.left != null) {
            destroy(bstNode.left);
        }
        if (bstNode.right != null) {
            destroy(bstNode.right);
        }
        bstNode = null;
    }

    /***
     *
     * 销毁树
     *
     *
     */
    public void destroy() {
        destroy(mRoot);
        mRoot = null;
    }


    /***
     *
     * 删除结点(z)，并返回被删除的结点
     * @param key  删除的值
     *
     */
    public void remove(T key) {
        //tree 二叉树的根结点 deleteNode 删除的结点
        BSTNode<T> deleteNode;

        if ((deleteNode = search(mRoot, key)) != null) {
            BSTNode<T> remove = remove(deleteNode);
            if (remove == remove.parent.right) {
                remove.parent.right=null;
            }

            if (remove == remove.parent.left) {
                remove.parent.left=null;
            }
        }
    }

    /***
     *
     * @param deleteNode 删除的结点
     * @return BSTNode<T>
     */
    private BSTNode<T> remove(BSTNode<T> deleteNode) {
        if (deleteNode.left == null && deleteNode.right == null) {
            return deleteNode;
        }

        BSTNode<T> localReplace = predecessor(deleteNode);
        deleteNode.key = localReplace.key;
        return remove(localReplace);
    }
}