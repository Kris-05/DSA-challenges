//17. Letter Combinations of a Phone Number

/*
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        return digits.equals("") ? list : buttons("",digits);
    }
    private List<String> buttons(String ans, String digits){
        if(digits.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }
        int digit = digits.charAt(0) - '0';
        int start = (digit - 2) * 3;
        if(digit > 7)
            start++;

        int len = start + 3;
        if(digit == 7 || digit == 9)
            len++;
        
        ArrayList<String> list = new ArrayList<>();
        for(int i=start; i<len; i++){
            char ch = (char)('a' + i);
            list.addAll(buttons(ans+ch,digits.substring(1)));
        }
        return list;
    }
}
