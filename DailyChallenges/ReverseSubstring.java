//1190. Reverse Substrings Between Each Pair of Parentheses

/*
You are given a string s that consists of lower case English letters and brackets.
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Your result should not contain any brackets.

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
*/

class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(')
                stack.push(str.length());   //pushing the start of reverse for every (
            else if(ch == ')'){
                int a = stack.pop();
                int b = str.length() - 1;       
                rev(str,a,b);               //then reverse the str from start to end by popping out
            }
            else
                str.append(ch);             //none parantheses found? just append the char
        }
        return str.toString();
    }
    static void rev(StringBuilder str, int start, int end){
        while(start<end){
            char temp = str.charAt(start);
            str.setCharAt(start,str.charAt(end));
            str.setCharAt(end,temp);
            start++;
            end--;
        }
    }
}
