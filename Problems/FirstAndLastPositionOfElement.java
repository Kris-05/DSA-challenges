// Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int begin = search(nums, target, true);
        int finish = search(nums, target, false);
        return new int[]{begin, finish}; 
    }
    static int search(int[] nums, int target, boolean firstTime){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < nums[mid])
                end = mid-1;
            else if(target > nums[mid])
                start = mid+1;
            else{
                ans = mid; 
                if(firstTime)
                    end = mid-1;    //to find the occurence in the left side
                else
                    start = mid+1;  //to find the occurence in the right side
            }        
        }
        return ans;
    }
}
