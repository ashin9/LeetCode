package org.ashing.backtracking;

public class exist79 {
    private int rows, cols;
    private char[][] board;
    private String word;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word;
        this.visited = new boolean[rows][cols];

        // 每个点作为起点尝试
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        // 递归边界
        if (index == word.length()) return true;

        // 剪枝, 越界 / 已访问 / 不匹配
        if (i < 0 || i >= rows || j < 0 || j >= cols) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(index)) return false;

        // 选择, 标记已访问
        visited[i][j] = true;

        // 递归搜索上下左右
        boolean found = dfs(i + 1, j, index + 1)
                     || dfs(i - 1, j, index + 1)
                     || dfs(i, j + 1, index + 1)
                     || dfs(i, j - 1, index + 1);

        // 撤销选择
        visited[i][j] = false;

        return found;
    }
}
