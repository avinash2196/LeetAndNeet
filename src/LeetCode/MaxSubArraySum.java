package LeetCode;

public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int maxArraySum = nums[0];
        int currArraySum = nums[0];
        for (int index = 1; index < nums.length; index++) {
            int num = nums[index];
            currArraySum = Math.max(num, currArraySum + num);
            maxArraySum = Math.max(currArraySum, maxArraySum);
        }
        return maxArraySum;
    }
}
