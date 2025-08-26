package Krahets88;

import java.util.HashMap;
import java.util.Map;

public class findDuplicate287 {
    /**
     * 1, 暴力搜索: 超时
     */
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    /**
     * 2, 用 Set / Map 存放, 可通过, 但超空间
     */
    public int findDuplicate2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                return nums[i];
            } else {
                m.put(nums[i], 1);
            }
        }
        return 0;
    }


    /**
     * 3, 二分查找方法, O(nlogn)
     * cnt[i] <= i 的个数, 具有单调性, 因此可用二分法
     * 如果没有重复数，那么 cnt[i] 应该恰好等于 i（因为数字范围是 [1, n]，且每个数唯一）。
     * 如果有重复数，会导致某些 cnt[i] 比 i 大。
     */
    public int findDuplicate3(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    /**
     * 4, 快慢指针, O(n) 最优解
     * 把数组当做链表, 用快慢指针找环的入口
     * 走两步 fast = nums[nums[fast]]
     * 返回值 p
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // 找到环
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 找到环的入口
        int p1 = 0;
        int p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1; // 注意返回的是 p
    }
}
