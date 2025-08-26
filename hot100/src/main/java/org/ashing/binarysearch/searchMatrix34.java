package org.ashing.binarysearch;

public class searchMatrix34 {

    /**
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix, target);
        if (row < 0) return false;              // 边界检查，防止 r == -1 的情况
        int l = 0, r = matrix[0].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    private int searchRow(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == matrix[mid][0]) {
                return mid;
            } else if (target > matrix[mid][0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;           // searchRow 要返回的是 最后一个行首 ≤ target 的行，所以要返回 r
    }
}
