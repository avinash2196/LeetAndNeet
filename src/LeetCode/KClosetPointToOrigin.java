package LeetCode;

import java.util.Arrays;

public class KClosetPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> sq(a) - sq(b));
        return Arrays.copyOf(points, k);
    }

    private int sq(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

}
