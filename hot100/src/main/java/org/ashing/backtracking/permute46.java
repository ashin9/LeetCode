package org.ashing.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permute46 {

    /**
     *
     */
    /*List<List<Integer>> res;
    List<Integer> nums;
    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.nums = new ArrayList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == nums.size() - 1) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = x; i < nums.size(); i++) {
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }*/



    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();         // 记录走过的路径

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];      // 记录是否走过该节点
        dfs(nums, used);
        return res;
    }

    private void dfs(int[] nums, boolean[] used) {
        // 递归边界
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path)); // path 是对象, 引用传递, 所以要传值复制给 res
            return;
        }
        // 遍历选择列表
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (used[i]) continue;

            // 选择
            path.add(nums[i]);
            used[i] = true;

            // 递归
            dfs(nums, used);

            // 撤销
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
