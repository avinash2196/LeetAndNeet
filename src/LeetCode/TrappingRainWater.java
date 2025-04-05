package LeetCode;

public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    answer = answer + leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    answer = answer + rightMax - height[right];
                }
                right--;
            }
        }
        return answer;
    }
}
