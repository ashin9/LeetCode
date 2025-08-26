package org.ashing.backtracking;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        if (n == 0 ) return res;
        dfs(n, 0, 0);
        return res;
    }

    private void dfs(int n, int left, int right) {
        // 递归边界
        if (path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }
        // 遍历路径
        // 选择加左括号
        if (left < n) {
            path.append('(');                          // 选择
            dfs(n, left + 1, right);
            path.deleteCharAt(path.length()-1); // 撤销选择
        }
        // 选择右括号（必须保证右括号不超过左括号）
        if (right < left) {
            path.append(')');
            dfs(n, left, right + 1);
            path.deleteCharAt(path.length()-1);
        }

    }
}
