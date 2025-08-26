package org.ashing.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 排序优化剪枝
        dfs(candidates, 0, target);
        return res;
    }

    void dfs(int[] candidates, int start, int target) {
        // 递归边界
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历选择
        for (int i = start; i < candidates.length; i++) {
            // 剪枝1, 子集和超过 target 结束循环，因为已经排序，后面元素子集和一定超过 target
            if (target - candidates[i] < 0) {
                break;
            }
            // 选择
            path.add(candidates[i]);
            // 递归
            dfs(candidates, i, target-candidates[i]);
            // 撤销
            path.remove(path.size()-1);
        }
    }
}
