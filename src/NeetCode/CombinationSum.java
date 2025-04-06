package NeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> results=new ArrayList();
            LinkedList<Integer> comb=new LinkedList();
            backTrack(target,0,comb,candidates,results);
            return results;
        }
        void backTrack(int remain,int start, LinkedList<Integer> combo,int[] candidates, List<List<Integer>> results){
            if(remain==0){
                results.add(new ArrayList<Integer>(combo));
                return;
            }
            else if(remain<0){
                return;
            }
            for(int i=start;i<candidates.length;i++){
                combo.add(candidates[i]);
                backTrack(remain-candidates[i],i,combo,candidates,results);
                combo.removeLast();
            }
        }
    public static void main(String[] args){
        int [] l={2,3,6,7};
        CombinationSum combinationSum=new CombinationSum();
        combinationSum.combinationSum(l,7);
    }
}
