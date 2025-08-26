package org.ashing.matrix;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder54 {
    /**
     * 矩阵螺旋输出
     * 思路: 定义好边界, 不出边界死循环输出
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        // 定义边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true) {
            // left -> right
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            if (++t > b) {
                break;
            }

            // top -> bottom
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) {
                break;
            }

            // right -> left
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            if (--b < t) {
                break;
            }

            // bottom -> top
            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}
