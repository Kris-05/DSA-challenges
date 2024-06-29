class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int total = (length*(length+1))/2;
        int sum = 0;
        for(int i=0;i<length;i++)
            sum+=nums[i];
        return total-sum;
    }
}
