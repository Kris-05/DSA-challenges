class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+n];
        for(int i=0; i<n+n; i++)
            arr[i] = nums[i%n];
        
        int count = 0;
        for(int ele : nums){
            if(ele == 1)
                count++;
        }

        int max = 0;
        int curr = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1)
                curr++;
            if(i >= count && arr[i - count] == 1)
                curr--;
            max = Math.max(max, curr);
        }
        return count - max;
    }
}
