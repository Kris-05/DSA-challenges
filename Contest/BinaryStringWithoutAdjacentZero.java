//3211. Generate Binary Strings Without Adjacent Zeros

/*
You are given a positive integer n.
A binary string x is valid if all substrings of x of length 2 contain at least one "1".
Return all valid strings with length n, in any order.

Input: n = 3
Output: ["010","011","101","110","111"]
*/

class Solution {
    public List<String> validStrings(int n) {
        ArrayList<String> list = new ArrayList<>();
        if(n==1){
            list.add("0");
            list.add("1");
            return list;
        }

        int j = 1<<n;
        for(int i=1; i<j; i++){
            String str = "";
            for(int k=n-1; k>=0; k--){
                if((int)((i>>k)&1) == 1)
                    str += "1";
                else
                    str += "0";
            }
            
            int flag = 0;
            for(int k=0; k<n-1; k++){
                if((str.charAt(k) == '0')  && (str.charAt(k+1) == '0')){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                list.add(str);
        }
        return list;
    }
}
