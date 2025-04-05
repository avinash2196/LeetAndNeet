package LeetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area=0,maximumArea=0;
        int len=height.length;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                area=(j-i)*(Math.min(height[j],height[i]));
                maximumArea=Math.max(area,maximumArea);
            }
        }
        return maximumArea;
    }
    public  int maxArea2(int[] height){
        int maximumArea=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            maximumArea=Math.max(maximumArea,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return  maximumArea;
    }
}
