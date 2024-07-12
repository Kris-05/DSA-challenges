//1717. Maximum Score From Removing Substrings

/*
You are given a string s and two integers x and y. You can perform two types of operations any number of times.
Remove substring "ab" and gain x points. For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points. For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
*/


class Solution {
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        String high,low;
        int high_point, low_point;

        if(x > y){
            high = "ab";        //high Priority string to be removed first
            high_point = x;     //respective point
            low = "ba";         //low Priority string to be removed latter
            low_point = y;      //respective point
        }
        else{
            high = "ba";
            low = "ab";
            high_point = y;
            low_point = x;
        }
    //implementing StringBuilder is more feasible than using Stack in case of Characters

        //remove high priority string first
        StringBuilder stack = new StringBuilder();     

        for(char ch : s.toCharArray()){
            boolean isFull = stack.length() > 0;   
            if(isFull && high.charAt(0) == stack.charAt(stack.length()-1) && high.charAt(1) == ch){
                ans += high_point;
                stack.setLength(stack.length() - 1);
            }
            else
                stack.append(ch);
        }

        //then remove low priority string
        String str = stack.toString();
        stack.setLength(0);
        
        for(char ch : str.toCharArray()){
            boolean isFull = stack.length() > 0;

            if(isFull && low.charAt(0) == stack.charAt(stack.length() - 1) && low.charAt(1) == ch){
                ans += low_point;
                stack.setLength(stack.length() - 1);
            }
            else
                stack.append(ch);
        }

        return ans;
    }
}
