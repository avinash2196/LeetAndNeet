package NeetCode;

import java.util.*;

public class MinOperationsToSort {
    public static int findMinNumbers(List<Integer> weights, List<Integer> dist) {
        int n = weights.size();
        int INF = Integer.MAX_VALUE;

        // Pair weights with their original indices
        List<int[]> paired = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            paired.add(new int[]{weights.get(i), i});
        }

        // Sort by weights to determine the target order
        paired.sort(Comparator.comparingInt(a -> a[0]));

        // DP array to store the minimum moves for each position
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0; // Base case: No moves required for the first weight

        // Iterate over each weight in sorted order
        for (int i = 1; i < n; i++) {
            int currentIndex = paired.get(i)[1];
            int currentDist = dist.get(currentIndex);

            for (int j = 0; j < i; j++) {
                int prevIndex = paired.get(j)[1];
                int prevDist = dist.get(prevIndex);

                // Check if the previous weight can reach this position
                if (prevIndex + prevDist * ((currentIndex - prevIndex) / prevDist) == currentIndex) {
                    dp[i] = Math.min(dp[i], dp[j] + (currentIndex - prevIndex) / prevDist);
                }
            }
        }

        // The last position contains the minimum moves to sort the array
        return dp[n - 1] == INF ? -1 : dp[n - 1];
    }

    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(4, 2, 1, 3);
        List<Integer> dist = Arrays.asList(1, 2, 3, 1);

        System.out.println(findMinNumbers(weights, dist)); // Example usage
    }
}

