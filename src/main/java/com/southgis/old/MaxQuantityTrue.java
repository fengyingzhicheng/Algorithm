package com.southgis.old;

import java.util.*;

public class MaxQuantityTrue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
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

        int[] s = new int[m];
        SegmentTree st = new SegmentTree(m);
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