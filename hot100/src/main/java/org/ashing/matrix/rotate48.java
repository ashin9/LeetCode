package org.ashing.matrix;

public class rotate48 {
    /**
     * 思路: 链式旋转左上角部分
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) { // 若 n 为奇数, 向上取整
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];         // 每次 ij 互换
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; // i 换 j 位置 i 不变
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i]; // j 换 i 位置 n-1 关系
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
