package org.ashing.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge56 {

    /**
     * 1, 先按左区间从小到大排序
     * 2, 判断前面右区间是否大于当前左区间, 如果大则可更新
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);

        List<int[]> res = new ArrayList<>();
        for (int[] p : intervals) {
            int m = res.size();
            if (m > 0 && p[0] <= res.get(m-1)[1]) { // 相交合并
                res.get(m-1)[1] = Math.max(res.get(m-1)[1], p[1]);
            } else { // 不相交无法合并
                res.add(p);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
