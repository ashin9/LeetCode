package Krahets88.Search;

import java.util.Arrays;

public class findKthLargest215 {

    /**
     * 内置排序, O(nlogn)
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


}
