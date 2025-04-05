package LeetCode;

import java.util.PriorityQueue;

public class KLargestElementWithoutSorting {
    public int findKthLargestWitHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        //using frequency as data might be duplicated
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int count[] = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        int remain = k;
        for (int num = count.length - 1; num >= k; num--) {
            remain = remain - count[num];
            if (remain <= 0) return num + min;
        }
        return -1;
    }
}
