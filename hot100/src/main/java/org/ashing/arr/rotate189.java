package org.ashing.arr;

public class rotate189 {

    public void rotate(int[] nums, int k) {
        // 三次翻转
        // 1, 整个数组翻转; 2, 翻转前 k 个; 3, 翻转后 n - k 个
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        // 双指针
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;

            i++;
            j--;
        }
    }
}
