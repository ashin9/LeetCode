package Krahets88.DoublePointer;

public class isSubsequence392 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";

        System.out.println(isSubsequence(s1, s2));
    }

    /**
     * 双指针, 只要双指针都没到长度, 就当前字符相等等同步移动, 否则移动 t 的指针, 若 s 指针到头则判断为是
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int sn = s.length();
        int tn = t.length();
        if (sn > tn) {
            return false;
        }
        if (sn == 0) {
            return true;
        }

        int i = 0;
        int j = 0;
        while (i < sn && j < tn) {
            char sc = s.charAt(i);
            char tc = t.charAt(j);
            if (sc == tc) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i == sn) {
                return true;
            }
        }
        return false;
    }
}
