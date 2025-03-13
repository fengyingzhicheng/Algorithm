package com.southgis.old;

import java.util.*;

import static java.nio.file.Files.find;

/**
 * @author 王军
 * @date 2025/03/13
 */
public class MaxQuantityTrue {
    /**
     * 初始化一个数组s，长度为m，初始值全为0。
     * <p>
     * 对于每个块（来自所有行），找到其列区间中的所有列，从中选择s[j]最大的列j。如果有多个最大值，可以选择其中任意一个（例如，选择最左边的，或者最右边的）。
     * <p>
     * 将选择的列j对应的s[j]加1。
     * <p>
     * 所有块处理完后，计算总质量，即sum(s[j]^2 for j in 0..m-1)。
     * <p>
     * <p>
     * 对于每个块来说，需要遍历其列区间中的所有列，找到s[j]最大的那个。如果块的数量很大，或者每个块的列区间很大，这样的操作的时间复杂度可能很高。
     * 例如，假设每个块的列区间包含k列，那么每个块的处理时间为O(k)。如果有B个块，总时间为O(Bk)。如果k很大（例如，每个块覆盖整个行m列），那么总时间可能很高。
     * 因此，需要找到一种高效的方法，来快速找到每个块的列区间中的最大值。
     *
     * @param args
     * @author: 王军
     * @date: 2025/03/13
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //块
        List<int[]> blocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                a--;
                b--;
                blocks.add(new int[]{a, b});
            }
        }

        //表示 每一列对应的最大值
        int[] s = new int[m];
        SegmentTreeNode st = SegmentTreeNode.buildTree(m);
        System.out.println(st);
//        SegmentTree st = new SegmentTree(m);
        for (int[] block : blocks) {
            int l = block[0];
            int r = block[1];
            int[] res = st.query(l, r);
            int j = res[1];
            s[j]++;
            st.update(j, s[j]);
        }

        long sum = 0;
        for (int j = 0; j < m; j++) {
            sum += (long) s[j] * s[j];
        }
        System.out.println(sum);
    }
}

class SegmentTreeNode {
    /**
     * 左边界
     *
     * @required
     */

    int leftBound;
    /**
     * 右边界
     *
     * @required
     */
    int rightBound;
    /**
     * 最大值
     *
     * @required
     */

    int maxVal;
    /**
     * 最大值的最右侧位置
     *
     * @required
     */

    int maxPos;
    /**
     * 左子树
     *
     * @required
     */

    SegmentTreeNode left;
    /**
     * 右子树
     *
     * @required
     */

    SegmentTreeNode right;

    /**
     * @param leftBound
     * @param rightBound
     * @param maxVal
     * @param maxPos
     * @author: 王军
     * @date: 2025/03/13
     */

    public SegmentTreeNode(int leftBound, int rightBound, int maxVal, int maxPos) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.maxVal = maxVal;
        this.maxPos = maxPos;
    }


    @Override
    public String toString() {
        return "SegmentTreeNode{" +
                "leftBound=" + leftBound +
                ", rightBound=" + rightBound +
                ", maxVal=" + maxVal +
                ", maxPos=" + maxPos +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static SegmentTreeNode buildTree(int m) {
        //头节点
        return buildNode(0, m - 1);
    }

    private static SegmentTreeNode buildNode(int leftBound, int rightBound) {
        if (leftBound > rightBound) {
            return null;
        }
        if (leftBound == rightBound) {
            return new SegmentTreeNode(leftBound, rightBound, 0, rightBound);
        }
        //所有节点默认最大值0 最大值位置最右侧
        SegmentTreeNode left = buildNode(leftBound, (leftBound + rightBound) / 2);
        SegmentTreeNode right = buildNode((leftBound + rightBound) / 2 + 1, rightBound);
        SegmentTreeNode root = new SegmentTreeNode(leftBound, rightBound, 0, rightBound);
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 查询区间[l, r]中的最大值及其位置
     *
     * @param l
     * @param r
     * @return {@link int[] }
     * @author: 王军
     * @date: 2025/03/13
     */

    public int[] query(int l, int r) {
        if (r < l) {
            throw new UnsupportedOperationException("不支持的分块");
        }
        if (leftBound < l || rightBound > r) {
            //合法的区间
            int middle = (leftBound + rightBound) / 2;
            if (l > middle) {
                return right.query(l, r);
            }
            if (r <= middle) {
                return left.query(l, r);
            }
            int[] leftRes = left.query(l, middle);
            int[] rightRes = right.query(middle + 1, r);
            if (leftRes[0] == rightRes[0]) {
                //值相等选择右边的返回
                return new int[]{rightRes[0], rightRes[1]};
            } else {
                //返回最大的值和位置
                return leftRes[0] > rightRes[0] ? leftRes : rightRes;
            }

        } else if (leftBound == l && rightBound == r) {
            return new int[]{maxVal, maxPos};
        } else {
            throw new UnsupportedOperationException("不支持的分块");
        }
    }

    /**
     * 更新线段树中的某个节点的值
     * 线段树需要更新其父节点 更新逻辑
     * 递归找到 leftBound = rightBound = j的子节点
     * 更新子节点值
     * 递归返回时候更新父节点的值 和 位置
     *
     * @param j 节点
     * @param value
     * @author: 王军
     * @date: 2025/03/13
     */

    public void update(int j, int value) {
        update(this,j,value);
    }

    public void update(SegmentTreeNode segmentTreeNode,int j, int value) {
        if (segmentTreeNode.leftBound == segmentTreeNode.rightBound) {
            //找到叶子节点更新值
            segmentTreeNode.maxVal = value;
        }else {
            //中间节点
            int middle= (segmentTreeNode.leftBound + segmentTreeNode.rightBound) / 2;
            if(j<=middle){
                //左子树中找到更新
                update(segmentTreeNode.left,j,value);
            }else {
                //右子树中找到更新
                update(segmentTreeNode.right,j,value);
            }
            if(segmentTreeNode.left.maxVal>segmentTreeNode.right.maxVal){
                segmentTreeNode.maxVal=segmentTreeNode.left.maxVal;
                segmentTreeNode.maxPos=segmentTreeNode.left.maxPos;
            }else {
                segmentTreeNode.maxVal=segmentTreeNode.right.maxVal;
                segmentTreeNode.maxPos=segmentTreeNode.right.maxPos;
            }
        }
    }
}

/**
 * 可以使用线段树或者稀疏表等数据结构，来快速查询区间的最大值及其位置。
 * 这样，每个块的查询时间为O(log m)或者O(1)，然后更新该位置的值，同样需要O(log m)的时间。
 * 可以预先将每个块的列区间记录下来，然后按照任意顺序处理这些块。
 * 对于每个块的列区间[l, r]，查询该区间中的最大值的位置j。如果有多个位置具有最大值，则可以选择最左边的或最右边的。
 * <p>
 * 因此，数据结构需要能够快速查询区间内的最大值，并返回对应的位置。如果使用线段树，
 * 每个节点存储当前区间的最大值以及对应的位置。在查询时，可以找到区间内的最大值，并返回对应的最右侧的位置。
 * <p>
 * 这可能需要在线段树的节点中，不仅保存最大值，还保存最大值的最右位置。
 * 例如，每个节点保存最大值和对应的最右的位置。这样，在查询区间的最大值时，可以同时得到该最大值的最右侧的位置。
 * 同样，在更新时，只需要将该位置的s[j]加1，并更新线段树中的对应节点的信息。
 * 因此，总的时间复杂度为O(B log m + m)，其中B是块的总数。这应该可以处理较大的数据规模。
 *
 * @author 王军
 * @date 2025/03/13
 */
class SegmentTree {
    private int[] maxVal;
    private int[] maxPos;
    private int size;

    public SegmentTree(int m) {
        this.size = m;
        int n = 1;
        while (n < m) {
            n <<= 1;
        }
        maxVal = new int[2 * n];
        maxPos = new int[2 * n];
        build(0, 0, m - 1);
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            maxVal[node] = 0;
            maxPos[node] = l;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid);
        build(2 * node + 2, mid + 1, r);
        updateNode(node);
    }

    private void updateNode(int node) {
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        if (maxVal[leftChild] > maxVal[rightChild]) {
            maxVal[node] = maxVal[leftChild];
            maxPos[node] = maxPos[leftChild];
        } else if (maxVal[rightChild] > maxVal[leftChild]) {
            maxVal[node] = maxVal[rightChild];
            maxPos[node] = maxPos[rightChild];
        } else {
            maxVal[node] = maxVal[leftChild];
            maxPos[node] = Math.max(maxPos[leftChild], maxPos[rightChild]);
        }
    }

    public void update(int pos, int val) {
        update(0, 0, size - 1, pos, val);
    }

    private void update(int node, int l, int r, int pos, int val) {
        if (l == r) {
            maxVal[node] = val;
            maxPos[node] = pos;
            return;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) {
            update(2 * node + 1, l, mid, pos, val);
        } else {
            update(2 * node + 2, mid + 1, r, pos, val);
        }
        updateNode(node);
    }

    public int[] query(int L, int R) {
        return query(0, 0, size - 1, L, R);
    }

    private int[] query(int node, int l, int r, int L, int R) {
        if (r < L || l > R) {
            return new int[]{-1, -1};
        }
        if (L <= l && r <= R) {
            return new int[]{maxVal[node], maxPos[node]};
        }
        int mid = (l + r) / 2;
        int[] leftRes = query(2 * node + 1, l, mid, L, R);
        int[] rightRes = query(2 * node + 2, mid + 1, r, L, R);
        if (leftRes[0] == -1) {
            return rightRes;
        } else if (rightRes[0] == -1) {
            return leftRes;
        } else {
            if (leftRes[0] > rightRes[0]) {
                return leftRes;
            } else if (rightRes[0] > leftRes[0]) {
                return rightRes;
            } else {
                int maxP = Math.max(leftRes[1], rightRes[1]);
                return new int[]{leftRes[0], maxP};
            }
        }
    }
}