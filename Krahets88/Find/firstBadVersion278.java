package Krahets88.Find;

public class firstBadVersion278 {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while ( i <= j) {
            // 向下取整除法计算中点 m
            int mid = i + (j - i) / 2;
            if (isBadVersion(mid)) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        // i 指向首个错误版本，j 指向最后一个正确版本
        return i;
    }
}
