package org.ashing.hash;

import java.util.HashMap;
import java.util.Map;

public class twoSum1 {
    /**
     * 暴力 O(n^2)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * Map<nums[i], i>, 查找是否有元素 = target - nums[i]
     * 若 containsKey 则返回, 若无则 put
     */
    public int[] twoSum(int[] nums, int target) {
        // 遍历 map 是否存在 target - nums[i]
        // 有则返回, 否则加入 map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }

}
