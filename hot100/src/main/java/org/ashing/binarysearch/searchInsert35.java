package org.ashing.binarysearch;

public class searchInsert35 {

    /**
     * 若 l 和 r 都很大, 则 (l+r) 会溢出, l+(r-l)/2不会溢出
     * 有时候找右边界会用 l + (r - l + 1) / 2
     * 为什么返回 left?
     *   循环结束时 left > right
     *   所有 < target 的数都排在 left 左边
     *   所有 >= target 的数据在 left 右边
     *   left 正好在第一个 >= target 的位置
     * 为什么不返回 mid?
     *   最后一次 mid 不更新
     * 为什么不返回 right?
     *   退出时 right < target, 总是小于 target
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
