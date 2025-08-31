package org.ashing.heap;

import java.util.PriorityQueue;

public class MedianFinder295 {
    private PriorityQueue<Integer> minHeap; // 存大的一半
    private PriorityQueue<Integer> maxHeap; // 存小的一半

    public MedianFinder295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        // 1, 先加到大顶堆
        maxHeap.offer(num);
        // 2, 平衡两边, 大顶堆的最大元素放到小顶堆
        minHeap.offer(maxHeap.poll());
        // 3, 若小顶堆元素 > 大顶堆, 调整回来
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
