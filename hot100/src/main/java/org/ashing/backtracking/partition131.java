package org.ashing.backtracking;

import java.util.ArrayList;
import java.util.List;

public class partition131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        // 递归边界
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历选择, 从 start 开始枚举切割点
        for (int i = start; i < s.length(); i++) {
            // 剪枝, 若不是回文则跳过
            if (!isPalindrome(s, start, i)) continue;
            // 选择
            path.add(s.substring(start, i + 1));
            // 递归
            dfs (s, i + 1);
            // 撤销
            path.remove(path.size() - 1);
        }
    }

    // 判断 s[l..r] 是否是回文串
    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
