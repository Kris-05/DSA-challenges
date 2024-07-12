//3210. Find the Encrypted String

class Solution {
    public String getEncryptedString(String s, int k) {
        int n = s.length();
        k %= n;
        
        StringBuilder str = new StringBuilder(s);
        rev(str,0,k-1);
        rev(str,k,n-1);
        rev(str,0,n-1);

        return str.toString();
    }
    private void rev(StringBuilder s,int i,int j){

        while(i <= j){
            char temp = s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,temp);
            i++;
            j--;
        }
    }
}
