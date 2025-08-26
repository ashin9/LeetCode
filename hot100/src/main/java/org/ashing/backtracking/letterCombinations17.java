package org.ashing.backtracking;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations17 {

    private String[] letterMap = {
            " ",    // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder(); // 用 StringBuilder 更方便

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        dfs(digits, 0);
        return res;
    }

    private void dfs(String digits, int index) {
        // 递归出口：一个完整的组合
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }

        // 当前数字对应的字母集合
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];

        // 遍历所有字母
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));  // 做选择
            dfs(digits, index + 1);         // 递归
            path.deleteCharAt(path.length() - 1); // 撤销选择
        }
    }
}
