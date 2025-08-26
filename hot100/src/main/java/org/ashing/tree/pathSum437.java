package org.ashing.tree;

import java.util.HashMap;
import java.util.Map;

public class pathSum437 {

    /**
     * 类比和为 K 的子数组
     */
    private int res;
    public int pathSum1(TreeNode root, int targetSum) {
        // dfs 遍历树节点，假设当前节点作为路径终点，有多少个起点满足到终点路径和 = targetSum？
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return res;
    }

    private void dfs(TreeNode root, long s, int targetSum, Map<Long, Integer> cnt) {
        if (root == null) {
            return;
        }

        s += root.val;
        res += cnt.getOrDefault(s - targetSum, 0); // root 当做路径终点，多少起点

        cnt.merge(s, 1, Integer::sum); // cnt[s]++

        dfs(root.left, s, targetSum, cnt);
        dfs(root.right, s, targetSum, cnt);
        cnt.merge(s, -1, Integer::sum); // cnt[s]-- 恢复现场
    }


    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();  // 记录从根节点到各个节点的路径和出现的次
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long cur, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        cur += root.val;        // 前缀和

        ret = prefix.getOrDefault(cur - targetSum, 0); // 寻找是否存在某个祖先节点，使得 当前路径和 - 祖先路径和 = targetSum
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);

        ret += dfs(root.left, prefix, cur, targetSum);
        ret += dfs(root.right, prefix, cur, targetSum);
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);

        return ret;
    }
}
