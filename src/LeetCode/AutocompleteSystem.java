package LeetCode;

import java.util.*;

public class AutocompleteSystem {
    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> sentences;

        public TrieNode() {
            children = new HashMap<>();
            sentences = new HashMap<>();
        }
    }

    TrieNode root;
    TrieNode currNode;
    TrieNode dead;
    StringBuilder currSentence;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
        currSentence = new StringBuilder();
        currNode = root;
        dead = new TrieNode();
    }

    public List<String> input(char c) {
        if (c == '#') {
            addToTrie(currSentence.toString(), 1);
            currSentence.setLength(0);
            currNode = root;
            return new ArrayList<>();
        }
        currSentence.append(c);
        if (!currNode.children.containsKey(c)) {
            currNode = dead;
            return new ArrayList<>();
        }
        currNode = currNode.children.get(c);
        List<String> sentences = new ArrayList<>(currNode.sentences.keySet());
        Collections.sort(sentences, (a, b) -> {
            int countA = currNode.sentences.get(a);
            int countB = currNode.sentences.get(b);
            if (countA == countB) {
                return a.compareTo(b);
            }
            return countB - countA;
        });
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(3, sentences.size()); i++) {
            ans.add(sentences.get(i));
        }
        return ans;
    }

    private void addToTrie(String sentence, int count) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            int updatedCount = node.sentences.getOrDefault(sentence, 0) + count;
            node.sentences.put(sentence, updatedCount);    }
    }
}
