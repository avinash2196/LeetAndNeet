package LeetCode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap();
        for (String s : strs) {
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String key = String.valueOf(chArray);
            ans.computeIfAbsent(key, k -> new ArrayList()).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> ans = new HashMap();
        for (String s : strs) {
            Map<Character, Integer> countMap = new HashMap();
            for (char ch : s.toCharArray()) {
                countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
            }
            StringBuilder sb = new StringBuilder();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                sb.append(ch).append('#').append(countMap.getOrDefault(ch, 0)).append('#');
            }
            String key = sb.toString();
            ans.computeIfAbsent(key, k -> new ArrayList()).add(s);
        }
        return new ArrayList(ans.values());
    }
}
