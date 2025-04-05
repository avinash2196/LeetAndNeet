import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSub {
    public static int lengthOfLongestSubstring(String s) {
            int len=s.length()-1;
            int start=0,ans=0;
            Map<Character,Integer> maps=new HashMap();
            for(int i=0;i<=len;i++){
                char ch=s.charAt(i);
                if(maps.containsKey(ch)){
                    if(maps.get(ch)>=start){
                        start=maps.get(ch)+1;
                    }
                }
                ans=Math.max(ans,i-start+1);
                maps.put(ch,i);
            }
            return ans;
        }
    public static void main(String[] args){
        String s=" ";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
