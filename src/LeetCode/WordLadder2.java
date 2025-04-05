package LeetCode;

import java.util.*;

public class WordLadder2 {
    List<String> currPath = new ArrayList<>();
    List<List<String>> shortestPath = new ArrayList<>();
    Map<String, List<String>> adjList = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsSet = new HashSet<>(wordList);
        bfs(beginWord, endWord, wordsSet); //to created acyclic directed graph
        currPath.add(endWord);
        backtrack(endWord, beginWord);
        return shortestPath;
    }

    private void backtrack(String source, String destination) {
        if (source.equals(destination)) {
            List<String> temp = new ArrayList<>(currPath);
            Collections.reverse(temp);
            shortestPath.add(temp);
        }
        if (!adjList.containsKey(source)) return;
        for (String word : adjList.get(source)) {
            currPath.add(word);
            backtrack(word, destination);
            currPath.remove(currPath.size() - 1);
        }
    }

    private void bfs(String source, String destination, Set<String> wordsSet) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        wordsSet.remove(source);
        Set<String> globallyVisitedSet = new HashSet<>();
        globallyVisitedSet.add(source);
        while (!queue.isEmpty()) {
            Set<String> currLevelVisited = new HashSet<>();
            int size = queue.size();
            for (int i = size - 1; i >= 0; i++) {
                String currWord = queue.poll();
                List<String> neighbours = findNeighbours(currWord, wordsSet);
                for (String word : neighbours) {
                    currLevelVisited.add(word);
                    adjList.computeIfAbsent(word, k -> new ArrayList<>()).add(currWord);
                    if (!globallyVisitedSet.contains(word)) {
                        queue.add(word);
                        globallyVisitedSet.add(word);
                    }
                }
            }
            for (String word : currLevelVisited) {
                wordsSet.remove(word);
            }
        }
    }

    private List<String> findNeighbours(String currWord, Set<String> wordsSet) {
        List<String> neighbours = new ArrayList<>();
        char charList[] = currWord.toCharArray();
        for (int i = 0; i < currWord.length(); i++) {
            char oldChar = charList[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;
                if (oldChar == c || !wordsSet.contains(String.valueOf(charList))) continue;
                neighbours.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbours;
    }
}
