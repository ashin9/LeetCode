package org.ashing.binarysearch;

public class search33 {
    /**
     * 虽然被旋转, 但仍有一半是有序的, 在有序区间可二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 每次判断哪边有序, 有序的可二分搜索
            // 左半有序
            if (nums[l] <= nums[mid]) {
                // 在左半, 有序, 把另一半丢掉
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                }
                // 在右半, 无序, 去另一半搜索
                else {
                    l = mid + 1;
                }
            }
            // 右半有序
            else {
                // 在右半
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                }
                // 在左半
                else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
