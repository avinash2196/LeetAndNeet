package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    int ROWS;
    int COLUMNS;
    char[][] matrix;
    int SIZE;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.matrix = grid;
        this.ROWS = grid.length;
        this.COLUMNS = grid[0].length;
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (matrix[row][col] == '1') {
                    count++;
                    dfs(row, col);
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLUMNS || matrix[row][col] == '0') return;
        matrix[row][col] = '0';
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {-1, 0, 1, 0};
        for (int offset = 0; offset < 4; offset++) {
            dfs(row + rowOffset[offset], col + colOffset[offset]);
        }
    }

    public int numIslandsWithBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.matrix = grid;
        this.ROWS = grid.length;
        this.COLUMNS = grid[0].length;
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                if (matrix[row][col] == '1') {
                    matrix[row][col] = '0';
                    count++;
                    Queue<Integer> neighbours=new LinkedList<>();
                    neighbours.add(row*COLUMNS+col);
                    while(!neighbours.isEmpty()){
                        int id=neighbours.poll();
                        int r=id/COLUMNS;
                        int c=id%COLUMNS;
                        if(r-1>=0 && matrix[r-1][c]=='1'){
                            neighbours.add((r-1)*COLUMNS+c);
                            grid[r-1][c]='0';
                        }
                        if(r+1<ROWS && matrix[r+1][c]=='1'){
                            neighbours.add((r+1)*COLUMNS+c);
                            grid[r+1][c]='0';
                        }
                        if(c-1>=0 && matrix[r][c-1]=='1'){
                            neighbours.add((r)*COLUMNS+(c-1));
                            grid[r][c-1]='0';
                        }
                        if(c+1<COLUMNS && matrix[r][c+1]=='1'){
                            neighbours.add((r)*COLUMNS+(c+1));
                            grid[r][c+1]='0';
                        }
                    }
                }
            }
        }
        return count;
    }

}
