package LeetCode;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        //row contains starting index and col contains end index
        boolean[][] dp = new boolean[len][len];
        int[] ans = new int[]{0, 0};

        //all substring of length 1 ( all such are palindrome)
        for (int index = 0; index < len; index++)
            dp[index][index] = true;
        //for substring of length 2
        for (int index = 0; index < len - 1; index++) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                dp[index][index + 1] = true;
                ans[0] = index;
                ans[1] = index + 1;
            }
        }
        //for len >=3
        for (int lenOfSub = 2; lenOfSub < len; lenOfSub++) {
            for (int startIndex = 0; startIndex < len - lenOfSub; startIndex++) {
                int endIndex = startIndex + lenOfSub;
                if (s.charAt(startIndex) == s.charAt(endIndex) && dp[startIndex + 1][endIndex - 1])//check for in between so using
                //startIndex-1 as start and endIndex-1 as end
                {
                    dp[startIndex][endIndex] = true;
                    ans[0] = startIndex;
                    ans[1] = endIndex;
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}
