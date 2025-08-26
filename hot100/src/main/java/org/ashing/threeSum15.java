package org.ashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {

    /**
     *
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // 双指针需要排序, 找所有 nums[i] + num[j] = -nums[k]
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            // 跳过相同的数
            if (k > 0 && nums[k] == nums[k-1]) continue;

            // 双指针
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] < -nums[k]) {
                    i++;
                } else if (nums[i] + nums[j] > -nums[k]) {
                    j--;
                } else {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 两边界都收缩
                    i++;
                    j--;
                    // 跳过重复元素
                    while (i < j && nums[i] == nums[i-1]) i++; // 不能 nums[i--], 先取值再--
                    while (i < j && nums[j] == nums[j+1]) j--; // 同上
                }
            }
        }
        return res;
    }
}
