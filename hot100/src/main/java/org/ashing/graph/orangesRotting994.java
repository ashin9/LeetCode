package org.ashing.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class orangesRotting994 {

    /**
     * bfs
     * 时空 O(mn)
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        // 统计新鲜橘子, 并把一开始腐烂的橘子入队列
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // 只要有新鲜橘子且腐烂橘子队列非空, 就继续扩散腐烂
        int[][] DIRECTIONS = {{-1,0}, {1, 0}, {0,-1}, {0,1}}; // 四个方向
        int res = 0;
        while (fresh > 0 && !q.isEmpty()) {
            res++;
            for (int len = q.size(); len > 0; len--) {
                int[] pos = q.poll();
                for (int[] d : DIRECTIONS) {  // 对每个腐烂橘子四个方向腐烂
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        fresh--;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return fresh > 0 ? -1 : res;
    }
}
