package Krahets88.Find;

public class binSearch704 {

    /**
     * 传数组不好返回索引
     * 用双指针记录索引范围
     */
    public int search(int[] nums, int target) {
        // 双指针记录返回
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if ( nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
