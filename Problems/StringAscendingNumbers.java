// 2042. Check if Numbers Are Ascending in a Sentence

/*
A sentence is a list of tokens separated by a single space with no leading or trailing spaces. Every token is either a positive number consisting of digits 0-9 
with no leading zeros, or a word consisting of lowercase English letters.

For example, "a puppy has 2 eyes 4 legs" is a sentence with seven tokens: "2" and "4" are numbers and the other tokens such as "puppy" are words.
Given a string s representing a sentence, you need to check if all the numbers in s are strictly increasing from left to right
(i.e., other than the last number, each number is strictly smaller than the number on its right in s).
*/

class Solution {
    public boolean areNumbersAscending(String s) {
        String[] str = s.split(" ");
        int num = 0;
        for(String word : str){
            if(Character.isDigit(word.charAt(0))){      
                int digit = Integer.parseInt(word);  // [Integer.parseInt()] is used for digits >=2 & [s.charAt(i) - '0'] can be used for single digit numbers
                if(digit <= num)
                    return false;
                num = digit;
            }
        }
        return true;
    }
}
