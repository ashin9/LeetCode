package org.ashing.binarysearch;

public class searchRange34 {

    /**
     * 先找到一个值, 再向两边扩展, 最坏 O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int idx = searchTarget(nums, target);
        if (idx == -1) return new int[]{-1, -1};
        int l = idx, r = idx;
        /*while (l > 0) {
            if (nums[l-1] == target) {
                l--;
            }
            // 如果 nums[l-1] != target，既没有 break，也没有 l--，也没有更新任何东西, 死循环
        }
        while (r < nums.length - 1) {
            if (nums[r+1] == target) {
                r++;
            }
        }*/
        while (l > 0 && nums[l-1] == target) l--;
        while (r < nums.length - 1 && nums[r+1] == target) r++;
        return new int[]{l, r};
    }

    private int searchTarget(int[] nums, int target) {
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
        // return left;  // 没找到要返回-1
        return -1; // 没找到
    }

    /**
     * 找 left 和 target+1 的 left - 1
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int l = searchL(nums, target);
        int r = searchL(nums, target+1) - 1;

        if (l <= r && l >= 0 && r <= nums.length -1) {
            return new int[]{l, r};
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分找左边界, 「左闭右开」写法
     * r = nums.length → 保证能取到「插入到末尾」的情况。
     * l < r → 对应左闭右开区间 [l, r)，循环自然收敛。
     * r = mid → 保留当前 mid，因为它可能就是左边界。
     */
    private int searchL(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
