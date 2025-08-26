package org.ashing.stack;

import java.util.Stack;

public class dailyTemperatures739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<Integer> s = new Stack<>(); // 单调栈, 存下标
        for (int i = 0; i < n; i++) {     // 每个字符判断是否大于栈顶
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int idx = s.pop();
                res[idx] = i - idx;
            }
            s.push(i);
        }

        return res;
    }
}
