//41. First Missing Positive
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, i = 0;
        //cycle sort
        while(i < n){
            int correctIndex = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            //neglecting -ve & larger numbers
            else{
                i++;
            }
        }
        for(i=0; i<n; i++){
            //if missing within 1 to n
            if(nums[i] != i+1)
                return i+1;
        }
        //if missing is n
        return n+1;
    }
}
