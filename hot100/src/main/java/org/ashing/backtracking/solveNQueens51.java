package org.ashing.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solveNQueens51 {
    List<List<String>> res = new ArrayList<>();
    char[][] board;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        dfs(0);
        return res;
    }

    private void dfs(int row) {
        // 1. 递归出口：所有行都放完
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) solution.add(new String(r));
            res.add(solution);
            return;
        }

        // 2. 遍历选择：尝试在每一列放皇后
        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) continue;  // 剪枝：不合法位置跳过

            // 做选择
            board[row][col] = 'Q';

            // 递归：进入下一行
            dfs(row + 1);

            // 撤销选择
            board[row][col] = '.';
        }
    }

    // 检查 (row, col) 是否可放置皇后
    private boolean isValid(int row, int col) {
        // 检查同一列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // 检查左上对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // 检查右上对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
