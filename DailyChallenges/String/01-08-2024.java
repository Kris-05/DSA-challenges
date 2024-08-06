// 2678. Number of Senior Citizens

class Solution {
    public int countSeniors(String[] details) {
        int n = details.length;
        int count = 0;
        for(String str : details){
            int tens = str.charAt(11) - '0';
            int ones = str.charAt(12) - '0';
            int age = tens*10 + ones;
            if(age > 60)
                count++;
        }
        return count;
    }
}
