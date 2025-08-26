package org.ashing.graph;

public class numIslands200 {

    /**
     * dfs
     * 遍历所有 1
     * 从 1 上下左右 dfs 的同时置 0 防止重复
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        // 对每个为陆地的点dfs
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
