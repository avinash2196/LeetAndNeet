package LeetCode;

import java.util.*;

public class TreeCut {
    int ROWS, COLUMN;

    private class Tree {
        int height, row, column;

        Tree(int h, int r, int c) {
            height = h;
            row = r;
            column = c;
        }
    }

    private class Cell {
        int row, col, step;

        Cell(int r, int c, int s) {
            row = r;
            col = c;
            step = s;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        ROWS = forest.size();
        COLUMN = forest.get(0).size();
        List<Tree> trees = new ArrayList<>();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMN; col++) {
                int height = forest.get(row).get(col);
                if (height > 1)
                    trees.add(new Tree(height, row, col));
            }
        }
        Collections.sort(trees, Comparator.comparing(t -> t.height));
        int totalSteps = 0;
        int startRow = 0;
        int startCol = 0;
        for (Tree tree : trees) {
            int step = bfs(forest, startRow, startCol, tree.row, tree.column);
            if (step == -1)
                return -1;
            totalSteps += step;
            startRow = tree.row;
            startCol = tree.column;
        }
        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int startRow, int startCol, int targetRow, int targetColumn) {
        if (startRow == targetRow && startCol == targetColumn)
            return 0;
        boolean[][] visited = new boolean[ROWS][COLUMN];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(startRow, startCol, 0));
        visited[startRow][startCol] = true;
        int[][] offset = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            for (int[] off : offset) {
                int newRow = current.row + off[0];
                int newColumn = current.col + off[1];

                if (isValid(newRow, newColumn, forest, visited)) {
                    if (newRow == targetRow && newColumn == targetColumn)
                        return current.step + 1;
                    visited[newRow][newColumn] = true;
                    queue.add(new Cell(newRow, newColumn, current.step + 1));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int row, int column, List<List<Integer>> forest, boolean[][] visited) {
        return row >= 0 && column >= 0 && row < ROWS && column < COLUMN && forest.get(row).get(column) != 0 && !visited[row][column];
    }
}
