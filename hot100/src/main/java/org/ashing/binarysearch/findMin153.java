package org.ashing.binarysearch;

public class findMin153 {
    /**
     * 在无序的那一半
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // 右半无序, 旋转数组的性质是：最小值一定在右半边（当 nums[mid] > nums[r]）
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            // 左半无序
            else {
                r = mid;
            }
        }
        return nums[l];
    }
}
