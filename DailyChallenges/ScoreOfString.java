// Score of a String
/*
You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
*/
class Solution {
    public int scoreOfString(String s) {
        char[] arr = s.toCharArray();
        int score = 0;
        for(int i=0;i<arr.length-1;i++){
            score += Math.abs(arr[i]-arr[i+1]);
        }
        return score;
    }
}
