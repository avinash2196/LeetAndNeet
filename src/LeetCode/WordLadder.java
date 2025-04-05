package LeetCode;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList();
        Set<String> words = new HashSet<String>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) return level;
                List<String> neighbours = getNeighbours(currWord, words);
                for (String neigh : neighbours) {
                    words.remove(neigh);
                    queue.add(neigh);
                }
            }
        }
        return 0;
    }

    public List<String> getNeighbours(String word, Set<String> words) {
        List<String> neighbours = new ArrayList<String>();
        char charList[] = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;
                if (c == oldChar || !words.contains(String.valueOf(charList))) {
                    continue;
                }
                neighbours.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbours;
    }
}
