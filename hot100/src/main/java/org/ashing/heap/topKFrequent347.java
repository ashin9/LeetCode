package org.ashing.heap;

import java.util.*;

public class topKFrequent347 {

    /**
     * 哈希表 + 小顶堆
     * 哈希表存储每个出现的频率
     * 找第 K 个, 就是等价于 215 找第 K 小
     */
    public int[] topKFrequent(int[] nums, int k) {
        // HashMap 存储频率
        HashMap<Integer, Integer> freMap = new HashMap<>();
        for (int num : nums) {
            freMap.put(num, freMap.getOrDefault(num, 0) + 1);
        }
        // 维护 k 小顶堆
        // Integer, String 实现了 Comparable 接口, 默认升序排列
        // 而此处存储的元素为 Map, 没有实现 Comparable 接口, 编译器需要知道两个 Entry 之间如何比较
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> (a.getValue() - b.getValue())
        );

        for (Map.Entry<Integer, Integer> e : freMap.entrySet()) {
            minHeap.offer(e);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 构建 res
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    /**
     * Bucket Sort
     * 建一个数组 bucket，其中 bucket[f] 存所有出现 f 次的数字
     * 从高频到低频遍历桶，收集前 k 个数
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // 桶的下标表示频率
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            bucket[e.getValue()].add(e.getKey());
        }

        // 构造结果
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() <= k; i--) {
            res.addAll(bucket[i]);
        }

        return res.stream().mapToInt(x -> x).limit(k).toArray();
    }

}
