package NeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSlidingWindow {
    public static void main(String []args){
        int [] nums=new int[]{9,10,9,-7,-4,-8,2,-6};
        maxSlidingWindow(nums,5);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length;
        int [] ans=new int[len-k+1];
        int startIndex=0;
        Queue<Integer> heap=new PriorityQueue<Integer>((a, b)->nums[b]-nums[a]);
        for(int i=0;i<len;i++){

            while(heap.size()>0 && heap.peek()<=i-k)
                heap.remove();
            heap.add(i);
            if(i+1>=k){
                ans[startIndex++]=nums[heap.peek()];
            }

        }
        return ans;
    }
}
