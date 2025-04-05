package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, result);
            }
        }
        return result;
    }

    void twoSum(int[] nums, int i, List<List<Integer>> result) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                result.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }

    void twoSum2(int[] nums,int i,List<List<Integer>> result){
        int left=i+1;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[i]+nums[left]+nums[right];
            if(sum<0){
                left++;
            }else if(sum>0){
                right--;
            }else{
                result.add(Arrays.asList(nums[i],nums[left++],nums[right--]));
                while(left<right && nums[left]==nums[left-1])
                    left++;
            }
        }
    }
}
