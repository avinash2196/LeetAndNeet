package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            int numToBeFound = target - nums[index];
            if (intMap.containsKey(numToBeFound)) {
                return new int[]{index, intMap.get(numToBeFound)};  //solution found
            } else {
                intMap.put(nums[index], index); //store number and index
            }
        }
        return new int[0];
    }
}
