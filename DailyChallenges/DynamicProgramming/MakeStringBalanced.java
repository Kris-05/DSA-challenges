// 1653. Minimum Deletions to Make String Balanced

/*
Balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
*/

class Solution {
/*
    Stack<Character> stack = new Stack<>();
    int count = 0;
    for(char ch : s.toCharArray()){
        if(ch == 'a' && !stack.isEmpty()){
            stack.pop();
            count++;
        }
        else if(ch == 'b')
            stack.push(ch);
    }
*/
    public int minimumDeletions(String s) {
        int aCount = 0;  // a count
        int bCount = 0;  // b count
        for(char ch : s.toCharArray()){
            if(ch == 'b')
                bCount++;
            else{
                // check the number of b before with number of a we have. find its minimum
                aCount++;
                aCount = Math.min(aCount, bCount);
            }
        }

        return aCount;
    }
}
