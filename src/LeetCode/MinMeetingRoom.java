package LeetCode;

import java.util.Arrays;

public class MinMeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        for (int index = 0; index < intervals.length; index++) {
            startTime[index] = intervals[index][0];
            endTime[index] = intervals[index][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int currMax = 0;
        int count = 0, startTimeIndex = 0, endTimeIndex = 0;
        while (startTimeIndex < intervals.length) {
            if (startTime[startTimeIndex] < endTime[endTimeIndex]) {
                startTimeIndex++;
                count++;
            } else {
                endTimeIndex++;
                count--;
            }
            currMax = Math.max(currMax, count);
        }
        return currMax;
    }
}
