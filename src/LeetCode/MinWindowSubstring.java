package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        //for len 0
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> mapT = new HashMap();
        //create hashmap for t with count
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        //find size that needs to be checked

        int required = mapT.size();
        int left = 0;
        int right = 0;
        int[] ans = {-1, 0, 0};
        int matched = 0;
        Map<Character, Integer> mapS = new HashMap();

        //use two pointer and iterate over s to find word count
        while (right < s.length()) {

            char r = s.charAt(right);
            mapS.put(r, mapS.getOrDefault(r, 0) + 1);
            if (mapT.getOrDefault(r, -1).intValue() == mapS.get(r).intValue()) {
                matched++;
            }
            while (left <= right && matched == required) {
                char l = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                mapS.put(l, mapS.get(l) - 1);
                if (mapT.containsKey(l) &&
                        mapS.get(l).intValue() < mapT.get(l).intValue()) {
                    matched--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        //Inside loop ,verify if count of ch is equal to count of ch in t, if yes updated matchedCount
        //while matched ==required and left <right , update answer and keeps contracting the window
        //inside this only , decrement matched if ch is matched
    }
}
