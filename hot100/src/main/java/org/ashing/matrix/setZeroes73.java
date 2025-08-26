package org.ashing.matrix;

import java.util.HashSet;
import java.util.Set;

public class setZeroes73 {

    /**
     * 自己想到的思路, 空间 O(m+n)
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // 遍历一遍记录所有为 0 的行和列
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    set1.add(i);
                    set2.add(j);
                }
            }
        }

        // 再遍历一遍所有行列被记录的置 0
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (set1.contains(i) || set2.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 优化到 O(1)
     * 用第一行第一列标记该行列是否有 0
     * 但第一行第一列也要有额外空间来标记, 防止有 0 的情况
     */

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean row0_flag = false;
        boolean col0_flag = false;

        // 第一行是否有 0
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                row0_flag = true;
            }
        }
        // 第一列是否有 0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0_flag = true;
            }
        }

        // 把第一行第一列作为标记位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 置 0
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            if (col0_flag) {
                matrix[i][0] = 0;
            }
        }
        for (int j = 0; j < col; j++) {
            if (row0_flag) {
                matrix[0][j] = 0;
            }
        }
    }
}
