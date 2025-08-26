package Krahets88.Simulation;

import java.util.ArrayList;

public class rotate48 {
    /**
     * 1, 辅助数组, 空间复杂度 O(n^2)
     */
    public void rotate(int[][] matrix) {
        // 公式 matrix[i][j] -> matrix[j][n-1-i]

        // 辅助 matrix 保存, 空间复杂度 O(n^2)
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmp[i] = matrix[i].clone();
        }
        // 根据公式修改, 时间复杂度 O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n-1-i] = tmp[i][j];
            }
        }
    }

    /**
     * 2, 优化空间复杂度 O(1)
     * 因为是 n * n 的, 四个角元素旋转为例: 暂存A temp = A, A←D←C←B←tmp
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n+1) / 2; j++) {
                int tmp = matrix[i][j];
                // 每次 i 和 j 位置都互换, 列不变, 行变
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
