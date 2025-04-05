package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumber {

    private String phoneDigit;
    private final List<String> combinations=new ArrayList<>();
    private final Map<Character,String> letters=Map.of('2',"abc",
            '3',"def",'4',"ghi",'5',"jkl",'6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return combinations;
        phoneDigit=digits;
        backtrack(new StringBuilder(),0);
        return combinations;
    }

    private void backtrack(StringBuilder curr, int index) {
        if(phoneDigit.length()==curr.length())
        {
            combinations.add(curr.toString());
            return;
        }
        String possibleLetters=letters.get(phoneDigit.charAt(index));
        for(char letter : possibleLetters.toCharArray()){
            curr.append(letter);
            backtrack(curr,index+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
