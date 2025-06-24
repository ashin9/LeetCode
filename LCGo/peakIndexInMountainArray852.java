package LCGo;

import java.util.Arrays;

public class peakIndexInMountainArray852 {
    public static void main(String[] args) {
        int[] arr = {40,48,61,75,100,99,98,39,30,10};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        return indexOf(arr, Mountain(arr));
    }

    public static int Mountain(int[] arr) {
        int mid = (arr.length) / 2;
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return arr[mid];
        }
        if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            return Mountain(Arrays.copyOfRange(arr, mid, arr.length));
        }
        if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            return Mountain(Arrays.copyOfRange(arr, 0, mid + 1));
        }
        return -1;
    }

    public static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
