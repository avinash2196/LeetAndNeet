package LeetCode;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp=new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            for(String word:wordDict){
                //handle out of bound
                if(i<word.length()-1){
                    continue;
                }
                //check from start from if prefix is already matched
                if(i==word.length()-1 || dp[i-word.length()]){
                    if(s.substring(i-word.length()+1,i+1).equals(word)){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }
}
