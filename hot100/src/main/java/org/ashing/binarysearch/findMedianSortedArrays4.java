package org.ashing.binarysearch;

public class findMedianSortedArrays4 {
    /** 看不太懂
     * 二分法（划分数组法，推荐 ✅）
     * 我们要找到「左半部分」和「右半部分」，保证：
     *
     * 左半部分的元素数量 = 右半部分（或差 1）
     *
     * 左半部分的最大值 ≤ 右半部分的最小值
     *
     * 那么中位数就可以通过 左半最大值和右半最小值 得到。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证 nums1 短
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int totalLeft = (m + n + 1) / 2; // 左半部分的总长度

        int l = 0, r = m; // 在 nums1 上二分
        while (l <= r) {
            int i = l + (r - l) / 2; // nums1 左半选 i 个
            int j = totalLeft - i;   // nums2 左半选 j 个

            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // 满足划分条件
                if ((m + n) % 2 == 1) {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                } else {
                    return (Math.max(nums1LeftMax, nums2LeftMax)
                         +  Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                }
            } else if (nums1LeftMax > nums2RightMin) {
                r = i - 1; // i 太大, 左缩
            } else {
                l = i + 1; // i 太小, 右扩
            }
        }
        throw new IllegalArgumentException();
    }
}
