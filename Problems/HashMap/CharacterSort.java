// 451. Sort Characters By Frequency

/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        StringBuilder str = new StringBuilder();
        
        while(!map.isEmpty()){
            int max = Integer.MIN_VALUE;
            char ch = '\0';

            // find the character with max frequency
            for(Map.Entry<Character, Integer> freq : map.entrySet()){
                if(freq.getValue() > max){
                    max = freq.getValue();
                    ch = freq.getKey();
                }
            }

            // append it max times ince if we remove, it will gone forever
            for(int i=0; i<max; i++)
                str.append(ch);
            map.remove(ch);
        }

        return str.toString();
    }
}
