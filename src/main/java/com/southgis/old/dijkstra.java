package com.southgis.old;

import lombok.Getter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class dijkstra {
    /**
     * 节点编号以及长度
     * @author 风影
     * @date 2025/03/11
     */
    @Getter
    static class node
    {
        int x; //节点编号
        int length;//长度
        public node(int x,int length) {
            this.x=x;
            this.length=length;
        }
    }

    public static void main(String[] args){
        int[][] map = new int[6][6];//记录权值，顺便记录链接情况，可以考虑附加邻接表
        initmap(map);//初始化
        //六个编号均为false
        boolean bool[]=new boolean[6];

        //0号节点到当前i 节点的距离 默认认为无穷远
        int len[]=new int[6];//长度
        for(int i=0;i<6;i++)
        {
            len[i]=Integer.MAX_VALUE;
            bool[i]=false;
        }
        //六个优先级队列 边长小的在前
        PriorityQueue<node> priorityQueue=new PriorityQueue<>(6, Comparator.comparingInt(node::getLength));
        priorityQueue.add(new node(0,0));
        len[0]=0;

        while (!priorityQueue.isEmpty()){
            node poll = priorityQueue.poll();
            int x = poll.getX();
            int length = poll.getLength();

            bool[x]=true;
            int[] neighbor = map[x];
            for (int i = 0; i < neighbor.length; i++) {
                if(neighbor[i]>0&&!bool[i]){
                    //这个是相连的
                    node node = new node(i, length+neighbor[i]);
                    if(len[i]>node.length){
                        len[i]=node.length;
                        priorityQueue.add(node);
                    }
                }
            }
        }

        for(int i=0;i<6;i++)
        {
            System.out.println(len[i]);
        }

    }


    /**
     * 定义了0号到1号距离2
     * 定义了0号到2号距离3
     * 定义了0号到3号距离6
     *
     * @param map
     */
    private static void initmap(int[][] map) {
        map[0][1]=2;map[0][2]=3;map[0][3]=6;
        map[1][0]=2;map[1][4]=4;map[1][5]=6;
        map[2][0]=3;map[2][3]=2;
        map[3][0]=6;map[3][2]=2;map[3][4]=1;map[3][5]=3;
        map[4][1]=4;map[4][3]=1;
        map[5][1]=6;map[5][3]=3;
    }
}
