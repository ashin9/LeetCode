package org.ashing;

public class maxArea11 {

    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1, maxS = 0;
        while (i < j) {
            int curS = (j - i) * Math.min(height[i], height[j]);
            maxS = Math.max(maxS, curS);
            // 低的一端更新
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxS;
    }
}
