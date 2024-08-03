// 1209. Remove All Adjacent Duplicates in String II

class Solution {
    class CustomMap{
        char ch;
        int freq;
        public CustomMap(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<CustomMap> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().ch == ch)
                stack.peek().freq++;
            else
                stack.push(new CustomMap(ch, 1));
            if(stack.peek().freq == k)
                stack.pop();
        }

        StringBuilder str = new StringBuilder();
        for(CustomMap map : stack){
            str.append(Character.toString(map.ch).repeat(map.freq));
        }
        return str.toString();
    }
}
