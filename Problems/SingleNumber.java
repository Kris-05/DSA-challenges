// Single Duplicate Number in Array
class Solution {
    public int singleNumber(int[] nums) {
        int check = 0;
        for(int ele : arr){
            check^=ele;         //x^x=0 x^0=x 
        }
        return check;
    }
}
