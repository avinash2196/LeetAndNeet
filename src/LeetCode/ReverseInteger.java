package LeetCode;

public class ReverseInteger {

    public int reverse(int x) {
        int reversedInteger = 0;
        while (x != 0) {
            int currDigit = x % 10;
            if ((reversedInteger > Integer.MAX_VALUE / 10) || (reversedInteger == Integer.MAX_VALUE / 10 && currDigit > 7))
                return 0;
            if ((reversedInteger < Integer.MIN_VALUE / 10) || (reversedInteger == Integer.MIN_VALUE / 10 && currDigit < -8))
                return 0;
            reversedInteger = reversedInteger * 10 + currDigit;

        }
        return reversedInteger;
    }
}
