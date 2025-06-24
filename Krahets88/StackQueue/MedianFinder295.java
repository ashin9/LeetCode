package Krahets88.StackQueue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder295 {
    /**
     * 小顶堆保存大的一半, 大顶堆保存小的一半, 在添加元素时动态调整两个堆的数量, 两个互相倒
     * 若两个堆的元素数量相同, 则取两者堆顶值折中
     * 否则小顶堆元素数量多于大顶堆一个, 去小顶堆元素
     */
    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();                                 // 小顶堆存大半
            maxHeap = new PriorityQueue<>((x, y) -> y - x); // 大顶堆存小半
        }

        public void addNum(int num) {
            if (minHeap.isEmpty() || num > minHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
            // 互相倒, 保持数量平衡
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.offer(minHeap.poll());
            } else if (minHeap.size() < maxHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return minHeap.peek();
            }
        }
    }
}
