package org.ashing.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest215 {

    /**
     * 排序, 返回倒数第 k 个
     * O(nlogn)
     * 适合数据量小
     *  1, 即使只需要 1 个元素, 也要对所有数据排序
     *  2, 如果 n 很大, 对所有数据排序需要的 cpu 和 mem 开销都很大
     *  例如: 10 亿条数据找第 1000 大, 内存放下所有数据排序不现实
     *  所以适合数据量不大或者数据整体有序的场景
     *
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 维护大小为 k 的小顶堆
     * O(n) 插入, 当堆大小超过 k, 每次插入弹出堆顶最小元素, 结束时返回堆顶就是最小元素
     * 适合海量数据流
     *  1, 不需要对所有数据排序, 只需要维护一个 k 大小的堆, 空间复杂度只有 O(k)
     *  2, 可以处理数据流(Streaming), 来一个元素就处理一个元素，不需要一次性把数据全放内存里
     *  所以适合海量数据或数据流, 特别是 n 巨大, 而只关心前 k 个元素时
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            // minHeap.add(nums[i]);        // add 和 offer 都行
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

}
