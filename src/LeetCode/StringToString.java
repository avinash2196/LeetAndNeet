package LeetCode;

public class StringToString {
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        if (needleLen > haystackLen)
            return -1;
        for (int i = 0; i <= haystackLen - needleLen; i++) {
            for (int j = 0; j < needleLen; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
                if (j == needleLen - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
