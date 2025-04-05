package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String,Integer> romanToInt=new HashMap<>();
        romanToInt.put("M", 1000);
        romanToInt.put("D", 500);
        romanToInt.put("C", 100);
        romanToInt.put("L", 50);
        romanToInt.put("X", 10);
        romanToInt.put("V", 5);
        romanToInt.put("I", 1);
        int index=0;
        int result=0;
        while(index<s.length()){
            String currSymbol=s.substring(index,index+1);
            int currValue=romanToInt.get(currSymbol);
            int nextValue=0;
            if(index+1<s.length()){
                String nextSymbol=s.substring(index+1,index+2);
                nextValue=romanToInt.get(nextSymbol);
            }
            if(nextValue>currValue){
                result+=(nextValue-currValue);
                index+=2;
            }else{
                result+=currValue;
                index++;
            }
        }
        return result;
    }
}
