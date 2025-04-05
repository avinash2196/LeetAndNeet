/*
class test {
    def is_special(input_string):
    if not input_string:
    return "NO"  # Null or empty strings cannot be "special"

    n = len(input_string)
    if n < 2:
    return "NO"  # A single-character string cannot be split into two non-empty parts

    # Precompute palindromic possibilities using DP
    is_palindrome_after_removal = precompute_palindrome_info(input_string)

    # Check all possible split points
    for i in range(1, n):
    if is_palindrome_after_removal[0][i - 1] and is_palindrome_after_removal[i][n - 1]:
    return "YES"

    return "NO"


    def precompute_palindrome_info(s):
    n = len(s)
    dp = [[False] * n for _ in range(n)]

    # Base case: single-character substrings are trivially palindromes
    for i in range(n):
    dp[i][i] = True

    # Fill the DP table for substrings
    for length in range(2, n + 1):
    for i in range(n - length + 1):
    j = i + length - 1

    # Case 1: Characters at i and j are the same, check the inner substring
    if s[i] == s[j]:
    dp[i][j] = (length == 2) or dp[i + 1][j - 1]

    # Case 2: Remove one character (either i or j)
    if not dp[i][j]:
    dp[i][j] = (i + 1 <= j and dp[i + 1][j]) or (i <= j - 1 and dp[i][j - 1])

    return dp


    # Test Cases
    print(is_special("abcca"))  # YES
    print(is_special("abcde"))  # NO
    print(is_special("a"))      # NO
    print(is_special("ab"))     # YES
    print(is_special("aa"))     # YES
    print(is_special("aab"))    # YES
    print(is_special("civicracecar"))  # YES
    print(is_special(""))  # NO
    print(is_special(None))  # NO

}*/
