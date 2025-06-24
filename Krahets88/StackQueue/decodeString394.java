package Krahets88.StackQueue;

public class decodeString394 {

    /**
     * 递归思路
     * 辅助函数, 多一个参数保存 i
     *
     */
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }

    public String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi >= 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (c == ']') {
                return new String[] { String.valueOf(i), res.toString() };
            } else {
                res.append(String.valueOf(c));
            }
            i++;
        }

        return new String[] { res.toString() };
    }
}
