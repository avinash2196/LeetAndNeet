package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<Integer>((num1, num2) -> countMap.get(num2) - countMap.get(num1));
        for (int num : countMap.keySet()) {
            heap.add(num);
        }
        int[] topFrequentElements = new int[k];
        for (int i = 0; i < k; i++) {
            topFrequentElements[i] = heap.poll();
        }
        return topFrequentElements;
    }
}
