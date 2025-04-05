package LeetCode;

import java.util.*;

public class WordCount {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalizeStr=paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase();
        String [] words=normalizeStr.split("//s+");
        Set<String> bannedWords=new HashSet<String>();
        for(String word: words){
            bannedWords.add(word);
        }
        Map<String,Integer> wordCount=new HashMap();
        for(String word:words){
            if(!bannedWords.contains(word)){
                wordCount.put(word,wordCount.getOrDefault(word,0)+1);
            }
        }
        return Collections.max(wordCount.entrySet(),Map.Entry.comparingByKey()).getKey();
    }

}
