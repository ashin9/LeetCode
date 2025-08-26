package org.ashing.stack;

import java.util.Map;
import java.util.Stack;

public class largestRectangleArea84 {

    /**
     * 每个柱子, 所能构成的最大矩形为: 高度 * 最大宽度
     * 最大宽度为找到左右第一个比其矮的 right - left - 1
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();

        int n = heights.length;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights , 1, n); // 开头结尾加0, 避免边界处理麻烦
        heights = newHeights;
        n = heights.length;
        for (int i = 0; i < n; i++) {
            while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
                int h = heights[s.pop()];
                int w = i - s.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            s.push(i);
        }
        return maxArea;
    }
}
