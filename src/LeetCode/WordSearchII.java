package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {
    private char[][] board;
    private String[] words;
    private int ROWS;
    private int COLUMNS;
    private List<String> result = new ArrayList();

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        this.ROWS = board.length;
        this.COLUMNS = board[0].length;
        TrieNode root = CreateTree();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (root.children.containsKey(board[row][col])) {
                    search(row, col, root);
                }
            }
        }
        return result;
    }

    private void search(int row, int col, TrieNode root) {
        char curr = board[row][col];
        TrieNode node = root.children.get(curr);
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[row][col] = '#';
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {-1, 0, 1, 0};
        for (int d = 0; d < 4; d++) {
            int newRow = row + rowOffset[d];
            int newCol = col + colOffset[d];
            if (newRow < 0 || newRow == ROWS || newCol < 0 || newCol == COLUMNS) continue;
            if (node.children.containsKey(board[newRow][newCol])) search(newRow, newCol, node);
        }
        board[row][col] = curr;
    }

    private TrieNode CreateTree() {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char curr : word.toCharArray()) {
                if (!node.children.containsKey(curr)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(curr, newNode);
                }
                node = node.children.get(curr);
            }
            node.word = word;
        }
        return root;
    }
}
