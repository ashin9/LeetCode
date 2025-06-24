package LCGo;

public class transpose {
    /**
     * 正方形
     */
    public int[][] transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        return matrix;
    }

    /**
     * 非正方形
     */

}
