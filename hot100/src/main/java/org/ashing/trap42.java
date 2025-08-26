package org.ashing;

public class trap42 {

    /**
     * 按列求, O(n^2)
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int sum = 0;
        // 按列求，最两端的不考虑，因为一定没水
        for (int i = 1; i < height.length - 1; i++) {
            // 找出左边最高
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            // 找出右边最高
            int max_right = 0;
            for (int j = i + 1; j < height.length; i++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            // 找出两端较小的
            int min = Math.min(max_left, max_right);
            // 只有较小的 > 当前列才会有水
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }


    /**
     * 动态规划, 空间换时间, 记录第 i 列左右最高的墙的高度
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        // 按列求时，每次找最高的墙都重新遍历，可以优化
        // max_left(i) 表示第 i 列左边最高的墙的高度
        // max_left(i) = Max(max_left[i-1], height[i-1])
        // max_right(i) 表示第 i 列右边最高的墙的高度
        // max_right(i) = Max(max_right[i+1], height[i+1])
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i-1], height[i-1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i+1], height[i+1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}
