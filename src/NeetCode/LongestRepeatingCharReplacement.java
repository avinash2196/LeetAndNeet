package NeetCode;

import java.util.HashSet;

public class LongestRepeatingCharReplacement {
    public static int characterReplacement(String s, int k) {
        HashSet<Character> letterMaps = new HashSet();

        for (int i = 0; i < s.length(); i++)
            letterMaps.add(s.charAt(i));
        int start = 0;
        int maxLength = 0;
        for (Character letter : letterMaps) {
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == letter) {
                    counter++;
                }
                while (i - start + 1 - counter > k) {
                    if (s.charAt(start) == letter) {
                        counter--;
                    }
                    start++;
                }
                maxLength = Math.max(maxLength, i - start + 1);
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABCDABBA";
        System.out.println(characterReplacement(s,2));
    }
}
