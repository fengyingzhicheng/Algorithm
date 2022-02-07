package com.southgis.old.july.two.tree;

import lombok.ToString;

/**
 * @author 王军
 * AVL树的查找、插入和删除在平均和最坏情况下都是O(logn)
 * 往平衡二叉树中添加节点很可能会导致二叉树失去平衡，所以我们需要在每次插入节点后进行平衡的维护操作。插入节点破坏平衡性
 * LL——>左子树（L）的左孩子（L）中插入新节点后导致不平衡——>右旋
 * RR——>右子树（R）的右孩子（R）中插入新节点后导致不平衡——>左旋
 * LR——>左子树（L）的右孩子（R）中插入新节点后导致不平衡——>左旋+右旋
 * RL——>右子树（R）的左孩子（L）中插入新节点后导致不平衡——>右旋+左旋
 * @description
 * @date 2021/7/5 10:38
 */
public class AVLTree<T extends Comparable<T>> {
    public AVLTreeNode<T> mRoot;

    @ToString
    public static class AVLTreeNode<T extends Comparable<T>> {
        T key;
        int height;
        AVLTreeNode<T> left;
        AVLTreeNode<T> right;

        public AVLTreeNode(T key, AVLTreeNode<T> left, AVLTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }


    /**
     * 获取树的高度
     *
     * @param node 结点
     * @return int
     */
    private int height(AVLTreeNode<T> node) {
        if (node != null) {
            return node.height;
        }

        return 0;
    }

    /***
     *
     * 树的高度=根节点的高度
     *
     * @return int
     */
    public int height() {
        return height(mRoot);
    }


    /***
     *
     * LL: 左左对应的情况(右旋)。
     * @param treeNode 需要旋转的树根节点
     * @return AVLTreeNode<T> 旋转后的根节点
     */
    private AVLTreeNode<T> leftLeftRotation(AVLTreeNode<T> treeNode) {
        AVLTreeNode<T> treeNodeLeft;

        treeNodeLeft = treeNode.left;
        treeNode.left = treeNodeLeft.right;
        treeNodeLeft.right = treeNode;

        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        treeNodeLeft.height = Math.max(height(treeNodeLeft.left), treeNode.height) + 1;

        return treeNodeLeft;
    }

    /***
     *
     * RR: 右右对应的情况(左旋)。
     * @param treeNode 需要旋转的树根节点
     * @return AVLTreeNode<T> 旋转后的根节点
     */
    private AVLTreeNode<T> rightRightRotation(AVLTreeNode<T> treeNode) {
        AVLTreeNode<T> treeNodeRight;

        treeNodeRight = treeNode.right;
        treeNode.right = treeNodeRight.left;
        treeNodeRight.left = treeNode;

        treeNode.height = Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        treeNodeRight.height = Math.max(height(treeNodeRight.right), treeNode.height) + 1;

        return treeNodeRight;
    }

    /***
     *
     * LR：先左旋后右旋
     * @param treeNode 需要旋转的树根节点
     * @return AVLTreeNode<T> 旋转后的根节点
     */
    private AVLTreeNode<T> leftRightRotation(AVLTreeNode<T> treeNode) {
        //先左旋左树
        treeNode.left = rightRightRotation(treeNode.left);

        //再右旋
        return leftLeftRotation(treeNode);
    }

    /***
     *
     * RL：先右旋后左旋
     * @param treeNode 需要旋转的树根节点
     * @return AVLTreeNode<T> 旋转后的根节点
     */
    private AVLTreeNode<T> rightLeftRotation(AVLTreeNode<T> treeNode) {
        //先右旋右树
        treeNode.right = leftLeftRotation(treeNode.right);

        //再左旋
        return rightRightRotation(treeNode);
    }

    /***
     *
     * 插入结点值
     * @param key 新结点的值
     *
     */
    public void insert(T key) {
        mRoot = insert(mRoot, key);
    }

    /***
     *
     * 插入到某个树一个value
     * @param node 根节点
     * @param key 新节点值
     * @return AVLTreeNode<T>
     */
    private AVLTreeNode<T> insert(AVLTreeNode<T> node, T key) {
        if (node == null) {
            node = new AVLTreeNode<>(key, null, null);

        } else {
            int cmp = key.compareTo(node.key);

            // 应该将key插入到"node的左子树"的情况
            if (cmp < 0) {
                node.left = insert(node.left, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(node.left) - height(node.right) == 2) {
                    if (key.compareTo(node.left.key) < 0) {
                        //说明插入的是左树的左节点
                        node = leftLeftRotation(node);
                    } else {
                        //说明插入的是左树的右节点
                        node = leftRightRotation(node);
                    }
                }
            }
            // 应该将key插入到"node的右子树"的情况
            else {
                node.right = insert(node.right, key);
                // 插入节点后，若AVL树失去平衡，则进行相应的调节。
                if (height(node.right) - height(node.left) == 2) {
                    if (key.compareTo(node.right.key) > 0) {
                        //说明插入的是右树的右节点
                        node = rightRightRotation(node);
                    } else {
                        //说明插入的是右树的左节点
                        node = rightLeftRotation(node);
                    }
                }
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }


    /***
     * 删除结点(deleteNode)，返回根节点
     *
     * @param tree AVL树的根结点
     * @param deleteNode 待删除的结点 根节点
     * @return AVLTreeNode<T>
     */
    private AVLTreeNode<T> remove(AVLTreeNode<T> tree, AVLTreeNode<T> deleteNode) {
        // 根为空 或者 没有要删除的节点，直接返回null。
        if (tree == null || deleteNode == null) {
            return null;
        }
        int cmp = deleteNode.key.compareTo(tree.key);
        // 待删除的节点在"tree的左子树"中
        if (cmp < 0) {
            tree.left = remove(tree.left, deleteNode);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.right) - height(tree.left) == 2) {
                AVLTreeNode<T> r = tree.right;
                if (height(r.left) > height(r.right)) {
                    tree = rightLeftRotation(tree);
                } else {
                    tree = rightRightRotation(tree);
                }
            }
        }
        // 待删除的节点在"tree的右子树"中
        else if (cmp > 0) {
            //删除过右子树的某个结点
            tree.right = remove(tree.right, deleteNode);
            // 删除节点后，若AVL树失去平衡，则进行相应的调节。
            if (height(tree.left) - height(tree.right) == 2) {
                AVLTreeNode<T> l = tree.left;
                if (height(l.right) > height(l.left)) {
                    tree = leftRightRotation(tree);
                } else {
                    tree = leftLeftRotation(tree);
                }
            }
        }
        // tree是对应要删除的节点。
        else {
            // tree的左右孩子都非空
            if ((tree.left != null) && (tree.right != null)) {
                if (height(tree.left) > height(tree.right)) {
                    // 如果tree的左子树比右子树高；
                    // 则(01)找出tree的左子树中的最大节点
                    //   (02)将该最大节点的值赋值给tree。
                    //   (03)删除该最大节点。
                    // 这类似于用"tree的左子树中最大节点"做"tree"的替身；
                    // 采用这种方式的好处是: 删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<T> max = maximum(tree.left);
                    tree.key = max.key;
                    tree.left = remove(tree.left, max);
                } else {
                    // 如果tree的左子树不比右子树高(即它们相等，或右子树比左子树高1)
                    // 则(01)找出tree的右子树中的最小节点
                    //   (02)将该最小节点的值赋值给tree。
                    //   (03)删除该最小节点。
                    // 这类似于用"tree的右子树中最小节点"做"tree"的替身；
                    // 采用这种方式的好处是: 删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
                    AVLTreeNode<T> min = maximum(tree.right);
                    tree.key = min.key;
                    tree.right = remove(tree.right, min);
                }
            } else {
                tree = (tree.left != null) ? tree.left : tree.right;
            }
        }

        return tree;
    }

    /***
     *
     * 删除某个值
     * @param key 删除的值
     *
     */
    public void remove(T key) {
        AVLTreeNode<T> z;

        if ((z = search(mRoot, key)) != null) {
            mRoot = remove(mRoot, z);
        }
    }

    /**
     * 二叉树查找
     *
     * @param key 查找的值
     * @return BSTree<BSTNode < T>
     */
    public AVLTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /***
     *
     * 递归方式二分查找
     * @param treeNode 节点
     * @param key 查找的值
     * @return BSTree<BSTNode < T>
     */
    private AVLTreeNode<T> search(AVLTreeNode<T> treeNode, T key) {
        if (treeNode == null) {
            return null;
        }
        int cmp = key.compareTo(treeNode.key);
        if (cmp < 0) {
            return search(treeNode.left, key);
        } else if (cmp > 0) {
            return search(treeNode.right, key);
        } else {
            return treeNode;
        }
    }


    /***
     *
     * 查找最小值
     *
     * @return T
     */
    public T minimum() {
        if (mRoot == null) {
            return null;
        }
        AVLTreeNode<T> p = minimum(mRoot);
        return p.key;
    }


    /***
     *
     * 查找最大结点: 返回tree为根结点的AVL树的最大结点。
     * @param tree 查找开始的树根节点
     * @return AVLTreeNode<T>
     */
    private AVLTreeNode<T> maximum(AVLTreeNode<T> tree) {
        while (tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    /***
     *
     * 查找最大值
     *
     * @return T
     */
    public T maximum() {
        if (mRoot == null) {
            return null;
        }
        AVLTreeNode<T> p = maximum(mRoot);
        return p.key;
    }


    /***
     *
     * 查找最小结点: 返回tree为根结点的AVL树的最小结点。
     * @param tree 查找开始的树根节点
     * @return AVLTreeNode<T>
     */
    private AVLTreeNode<T> minimum(AVLTreeNode<T> tree) {
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /*
     * 销毁AVL树
     */
    private void destroy(AVLTreeNode<T> tree) {
        if (tree == null) {
            return;
        }

        if (tree.left != null) {
            destroy(tree.left);
        }
        if (tree.right != null) {
            destroy(tree.right);
        }

        tree = null;
    }

    public void destroy() {
        destroy(mRoot);
    }

    /*
     * 打印"二叉查找树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(AVLTreeNode<T> tree, T key, int direction) {
        if (tree != null) {
            if (direction == 0)    // tree是根节点
            {
                System.out.printf("%2d is root\n", tree.key, key);
            } else                // tree是分支节点
            {
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction == 1 ? "right" : "left");
            }

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null) {
            print(mRoot, mRoot.key, 0);
        }
    }


    /*
     * 前序遍历"AVL树"
     */
    private void preOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /*
     * 中序遍历"AVL树"
     */
    private void inOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /*
     * 后序遍历"AVL树"
     */
    private void postOrder(AVLTreeNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }
}