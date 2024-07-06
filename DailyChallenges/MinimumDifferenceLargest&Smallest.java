class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4)
            return 0;
        Arrays.sort(nums);

        int k = n-3;        //to check to min possible difference i.e last 3 elements
        int diff = nums[n-1] - nums[0];

        for(int i=k-1;i < n;i++){
            diff = Math.min(diff, nums[i] - nums[i-k+1]);
        }
        return diff;
    }
}
