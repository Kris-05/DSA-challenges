class Solution {
  //First Solution
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int ele : nums){
            if(countDigits(ele))
                count++;
        }
        return count;
    }
    static boolean countDigits(int num){
        int noOfDigits = 0;
        while(num!=0){
            num/=10;
            noOfDigits++;
        }
        if(noOfDigits % 2 == 0)
            return true;
        else
            return false;
    }
  //Second Solution
    // public int findNumbers(int[] nums) {
    //     int count = 0;
    //     for(int ele : nums){
    //        if((int) (Math.log10(ele)+1) % 2 == 0)
    //         count ++;
    //     }
    //     return count;
    // }
}
