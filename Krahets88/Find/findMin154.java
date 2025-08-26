package Krahets88.Find;

public class findMin154 {

    /**
     * 遍历一遍, 找最小值, O(n)
     */
    public int findMin1(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min){
                min = num;
            }
        }
        return min;
    }


    /**
     * 特征: 排序的, 因此可考虑二分法
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        // 特征: 排序的, 可考虑用二分法, 可实现 O(nlogn), 特殊情况全相等退化为 O(n)
        // 无重复元素可以标准二分, 有重复元素需要循环二分
        // 包含重复元素 时，nums[mid] 可能等于 nums[right]，导致无法直接判断最小值在左半还是右半。
        // 如果 nums[mid] == nums[right]，无法确定最小值的位置，只能缩小右边界
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (nums[m] > nums[j]) { // 可谁比较? 和右端对比
                i = m + 1;
            } else if (nums[m] < nums[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return nums[i];
    }
}
