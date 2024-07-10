//8. String to Integer (atoi)

/*
The algorithm for myAtoi(string s) is as follows:
=> Whitespace: Ignore any leading whitespace (" ").
=> Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
=> Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached.
    If no digits were read, then the result is 0.
=> Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. 
    Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
*/

class Solution {
    public int myAtoi(String s) {
    //remove whitespaces in string
        s = s.trim();
        if(s.length() == 0) return 0;
        int res = 0;
    //checking whether it starts with signs 
        int i = 0;
        i = (s.charAt(i) == '+' || s.charAt(i) == '-') ? 1 : 0;
    //check if it is negative
        boolean sign = false;
        sign = s.charAt(0) == '-';
    //convert remain string to number 
        while( i<s.length() && Character.isDigit(s.charAt(i)) ){
            int num = s.charAt(i) - '0';

            // int_max/10 cuz to check if it exceeds the range in nxt steps
            // num > 7 cuz last digit of int_max is 7, greater leads to overflow
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && num > 7))
                return sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            res = res*10 + num;
            i++;
        }
    //if non-digit comes then returns 0
        return sign ? -1*res : res;
    }
}
