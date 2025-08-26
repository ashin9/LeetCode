package Krahets88.Simulation;

public class myAtoi8 {

    /**
     * 自己思路, 没有处理整数溢出情况, 处理正数还要处理负数
     */
    public int myAtoi(String s) {
        s = s.trim();

        // 处理符号位, 1表示负, 0表示正
        int isPositive;
        if (s.charAt(0) == '-') {
            isPositive = 1;
        } else {
            isPositive = 0;
        }

        // 累加转换
        int n = s.length();
        int toi = 0;
        int bndry = Integer.MAX_VALUE / 10;
        for (int i = isPositive; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (toi > bndry || toi == bndry && (c-'0') > '7') {
                    toi = Integer.MAX_VALUE;
                    break;
                }
                toi = toi * 10 + c - '0';
            } else {
                break;
            }
        }
        toi = (isPositive == 0) ? toi : -toi;
        return toi;
    }



}
