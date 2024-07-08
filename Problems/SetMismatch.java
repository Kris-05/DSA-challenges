//Set Mismatch - repetition of one number and loss of another number
class Solution {
    public int[] findErrorNums(int[] nums) {
        int i=0;
        //cycle sort
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            else
                i++;
        }
        //to check the lost and repeated element
        for(i=0;i<nums.length;i++){
            if(nums[i] != i+1)
                return new int[]{nums[i],i+1};
        }
        return new int[] {-1, -1};   
    }
}
