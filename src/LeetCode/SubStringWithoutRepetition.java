package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubStringWithoutRepetition {
    public static void main(String args[]){
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring2(s));
    }
        public static int lengthOfLongestSubstring(String s) {
            if(s==null || s.length()==0){
                return 0;
            }
            int len=s.length();
            int maxLen=1;
            for( int i=0; i<len-1;i++){
                Set<Character> charSet=new HashSet<Character>();
                int currLen=1;
                charSet.add(s.charAt(i));
                for(int j=i+1;j<len;j++){
                    if(charSet.contains(s.charAt(j))){
                        break;
                    }else{
                        charSet.add(s.charAt(j));
                        currLen++;
                        if(currLen>maxLen){
                            maxLen=currLen;
                        }
                    }
                }
            }
            return maxLen;
        }
    public static int lengthOfLongestSubstring2(String s) {
        int len=s.length();
        int ans=0;
        Map<Character,Integer> mapIndex=new HashMap<Character,Integer>();
        int startIndex=0,currIndex=0;
        while(currIndex<len){
            if(mapIndex.containsKey(s.charAt(currIndex))){
                startIndex=Math.max(s.charAt(currIndex),startIndex);

                ans = Math.max(ans,currIndex-startIndex+1);
                mapIndex.put(s.charAt(currIndex),currIndex+1);
                currIndex++;
            }
        }
        return ans;
    }
}
