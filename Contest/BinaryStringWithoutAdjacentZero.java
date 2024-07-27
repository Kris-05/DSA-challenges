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

        // to find 2^n and find all the binary numbers
        int j = 1<<n;
        // given condition is it should have atleast one 1, so start from 1
        for(int i=1; i<j; i++){
            // generate binary number for each 1 to 2^n - 1
            String str = "";
            for(int k=n-1; k>=0; k--){
                if((int)((i>>k)&1) == 1)
                    str += "1";
                else
                    str += "0";
            }
            
            // check if adjacent bit is also zero
            int flag = 0;
            for(int k=0; k<n-1; k++){
                if((str.charAt(k) == '0')  && (str.charAt(k+1) == '0')){
                    flag = 1;
                    break;
                }
            }
            // if no, add it
            if(flag == 0)
                list.add(str);
        }
        return list;
    }
}
