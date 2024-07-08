// Find the Duplicate Number
class Solution {
    public int findDuplicate(int[] nums) {
        //A hashset to store unique numbers
        Set<Integer> set = new HashSet();
        
        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i]))
              return nums[i];            //to find duplicate
            else
              set.add(nums[i]);          //adding to hashset
        }
        return -1;
    }
}
