package LeetCode;

import java.util.*;

public class PrisonStateAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        //map to hold current state as key and index as value
        Map<String, Integer> seen = new HashMap<>();
        //List of states to get the data quickly once we find cycle
        List<int[]> states = new ArrayList<>();

        for (int day = 0; day < N; day++) {
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if (seen.containsKey(key)) {
                int cycleStart = seen.get(key);
                int cycleLength = day - cycleStart;
                int remaining = (N - cycleStart) % cycleLength;
                //find remaining by adding it to cycleStart
                return states.get(cycleStart + remaining);
            }
            seen.put(key, day);
            states.add(next);
            cells = next;
        }
        return cells;
    }

    private int[] nextDay(int[] cells) {
        int[] next = new int[8];
        for (int index = 1; index < 7; index++) {
            next[index] = (cells[index - 1] == cells[index + 1] ? 1 : 0);
        }
        return next;
    }
}
