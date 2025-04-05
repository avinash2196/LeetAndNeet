package LeetCode;

public class TwoSumInSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        while (startIndex < endIndex) {
            int sum = numbers[startIndex] + numbers[endIndex];
            if (sum == target) return new int[]{startIndex + 1, endIndex + 1};
            else if (sum < target) startIndex++;
            else endIndex--;
        }
        return new int[]{-1, -1};
    }
}
