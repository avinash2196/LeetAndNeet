public class SpecialSeq {

    public static void main(String[] args) {
        System.out.println(isSpecial("abcbsd")); // Example input
        System.out.println(isSpecial("d")); // Example input
        System.out.println(isSpecial("a")); // Example input
        System.out.println(isSpecial("ab")); // Example input
    }

    public static String isSpecial(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "NO"; // Null or empty strings cannot be "special"
        }

        int n = inputString.length();
        if (n < 2) return "NO"; // A single-character string cannot be split into two non-empty parts

        // Precompute palindromic possibilities using DP
        boolean[][] isPalindromeAfterRemoval = precomputePalindromeInfo(inputString);

        // Check all possible split points
        for (int i = 1; i < n; i++) {
            if (isPalindromeAfterRemoval[0][i - 1] && isPalindromeAfterRemoval[i][n - 1]) {
                return "YES";
            }
        }
        return "NO";
    }

    private static boolean[][] precomputePalindromeInfo(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // Base case: single-character substrings are trivially palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Base case: two-character substrings
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = true; // Any two characters can form a palindrome by removing one
        }

        // Fill the DP table for substrings of length >= 3
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                // Check if the substring can form a palindrome after removing at most one character
                dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                        || dp[i + 1][j]
                        || dp[i][j - 1];
            }
        }

        return dp;
    }


}
