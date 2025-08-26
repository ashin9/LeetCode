package org.ashing.stack;

import java.util.Stack;

public class decodeString394 {

    /**
     * 双栈, 一个存 num, 一个存 str
     * 遍历每个字符
     *  - 若为数字则构造数字
     *  - 若为[ 则数字进栈, curS 进栈, 并重置 num 和 curS
     *  - 若为] 则出栈数字, 出栈 str, 遍历数字次构造字符串
     *  - 若为字符则累计 curS
     * @param s
     * @return
     */

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        StringBuilder curS = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(curS.toString());
                // 重置
                num = 0;
                curS = new StringBuilder();
            } else if (c == ']') {
                int k = numStack.pop();
                StringBuilder decoded = new StringBuilder(strStack.pop());
                for (int i = 0; i < k; i++) {
                    decoded.append(curS);
                }
                curS = decoded;
            } else {
                curS = curS.append(c);
            }
        }
        return curS.toString();
    }
}
