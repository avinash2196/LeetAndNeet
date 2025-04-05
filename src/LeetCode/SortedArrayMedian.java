package LeetCode;

public class SortedArrayMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int left = 0;
        int right = l1;
        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (l1 + l2 + 1) / 2 - partitionA;
            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightA = (partitionA == l1) ? Integer.MAX_VALUE : nums1[partitionA];
            int minRightB = (partitionB == l2) ? Integer.MAX_VALUE : nums2[partitionB];
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((l1 + l2) % 2 == 0)
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                else
                    return Math.max(maxLeftA, maxLeftB);
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;//since  left of A is greater than right of B so more elements are from left , hence move to left by reducing right
                //we cant reduce left as its already min
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }
}
