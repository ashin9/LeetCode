package Krahets88.Find;

import java.util.Arrays;

public class pivotIndex724 {
    public int pivotIndex(int[] nums) {
        int sumLeft = 0, sumRight = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            sumRight -= nums[i];
            if (sumLeft == sumRight) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }
}
