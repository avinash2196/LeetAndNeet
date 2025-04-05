package LeetCode;

public class WordSearch {
    private char[][] board;
    private int ROWS;
    private int COLUMNS;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLUMNS = board[0].length;
        this.word = word;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (dfs(row, col, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index) {
        if (index == word.length())
            return true;
        char curr = word.charAt(index);
        if (row < 0 || row == ROWS || col < 0 || col == COLUMNS ||
                board[row][col] != curr)
            return false;
        board[row][col] = '#';
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {-1, 0, 1, 0};
        for (int d = 0; d < 4; d++) {
            if(dfs(row + rowOffset[d], col + colOffset[d], index + 1))
                return true;
        }
        board[row][col] = curr;
        return false;

    }
}
