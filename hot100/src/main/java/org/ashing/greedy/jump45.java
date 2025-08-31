package org.ashing.greedy;

import java.util.Map;

public class jump45 {

    public int jump(int[] nums) {
        int minTime = 0;
        int maxRange = 0;
        int end = 0;            // 维护当前能跳跃到的最远位置

        for (int i = 0; i < nums.length - 1; i++) {  // 到倒数第二个即可
            maxRange = Math.max(maxRange, i + nums[i]);
            if (i == end) {
                minTime++;
                end = maxRange;
            }
        }

        return minTime;
    }
}
