package org.ashing.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class canFinish207 {
    /**
     * 问题等价于判断给的图是否是 DAG
     * 拓扑排序
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 邻接表记录每个课程的后继课程
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 入度表记录每个节点的入度
        int[] ingress = new int[numCourses];
        // 填充入度数组和邻接表
        for(int[] cp : prerequisites) {
            ingress[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        // 入度为 0 的课程可以立马开始
        for (int i = 0; i < numCourses; i++) {
            if (ingress[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int pre = q.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if (--ingress[cur] == 0) {
                    q.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
