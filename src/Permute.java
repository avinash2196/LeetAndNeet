import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> answer=new ArrayList();
            backTrack(new LinkedList(),answer,nums);
            return answer;
        }

        void backTrack(LinkedList<Integer> currList,List<List<Integer>>  answer,int []nums){
            if(currList.size()==nums.length){
                answer.add(new LinkedList<>(currList));
                return;
            }
            for(int num:nums) {
                if (!currList.contains(num)) {
                    currList.add(num);
                    backTrack(currList, answer, nums);
                    currList.removeLast();
                }
            }
    }
        public static void main(String[] args){
            int [] nums={1,2,3};
            Permute permute=new Permute();
            permute.permute(nums);
        }
}
