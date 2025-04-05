package LeetCode;

import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i =0;i<nums.length-2;i++)
        {
            int j = i+1;
            int k = nums.length-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == target)
                {
                    return sum;
                }
                if(sum<target)
                    j++;
                else
                    k--;
                int diff = Math.abs(sum-target);
                if(diff<minDiff)
                {
                    minDiff = diff;
                    closest = sum;
                }

            }
        }
        return closest;
    }
}
