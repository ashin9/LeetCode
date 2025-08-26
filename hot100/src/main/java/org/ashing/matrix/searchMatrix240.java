package org.ashing.matrix;

public class searchMatrix240 {
    /**
     * 1. 暴力搜索, O(M*N)
     */

    /**
     * 2. 二分搜索, O(M*logN)
     * 特征: 有序
     */

    /**
     * 3. BST 搜索
     * 把图逆向旋转 45 度, 类似 BST
     * 从左下角元素开始找
     *  - 若 target < flag 则 flag 这行不用找了, i--
     *  - 若 target > flag 则 flag 这列不用找了, j++
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}
