package NeetCode;

public class AnagramSolution {

    public static void main(String[] args){
    //    isAnagram("bbcc","ccbc");
        getConcatenation(new int[]{1,2,3});
    }

    public boolean isSubsequence(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();

        if(sLen<tLen)
            return false;
        for(int index=0;index<tLen-sLen;index++){
            if(t.substring(index,index+sLen).equals(sLen) ){
                return true;
            }
        }
        return false;
    }
    public static int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int [] result=new int [n *2];
        for(int i=n;i<2*n;i++){
            result[i-n]=nums[i-n];
            result[i]=nums[i-n];
        }
        return result;
    }
    public static boolean isAnagram(String s, String t) {
        if(s==null && t==null){
            return true;
        }else if((s==null && t!=null)|| (t==null && s!=null) ){
            return false;
        }else if(s.length()!=t.length()){
            return false;
        }else{
            int []chars= new int[26];
            char [] charsFirst=s.toCharArray();
            char [] charsSecond=t.toCharArray();
            for(char ch:charsFirst){
                chars[ch-'a']++;
                if(t.contains(String.valueOf(ch))){
                    chars[ch-'a']--;
                }
            }
            for(char i=0;i<26;i++){
                if(chars[i]!=0){
                    System.out.println("i"+i +" chars[i]" + chars[i]);
                    return false;
                }
            }
            return true;
        }
    }
}
