package LCGo;

import java.util.HashMap;
import java.util.Map;

public class numIdenticalPairs {
    /** 优化时间复杂度为 O(n), 空间复杂度也为 O(n)
     * 当一个数字出现次数为1时，好数对个数为0；
     * 出现2次时，好数对个数为C^2_2=1；
     * 出现3次时，好数对个数为C^2_3=3；
     * 出现4次，C^2_4=6;
     * 以此类推，出现n次n>=2时，C^2_n=n!/2!(n-2)!=n(n-1)/2。
     */
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num: nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }

        return ans;
    }
}
