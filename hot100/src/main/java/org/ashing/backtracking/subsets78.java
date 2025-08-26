package org.ashing.backtracking;

import java.util.ArrayList;
import java.util.List;

public class subsets78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        // 遍历选择
        for (int i = start; i < nums.length; i++) {
            // 选择
            path.add(nums[i]);
            // 递归
            dfs(nums, i + 1);
            // 撤销
            path.remove(path.size() - 1);
        }
    }
}
