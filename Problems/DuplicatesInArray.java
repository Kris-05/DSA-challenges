// Find All Duplicates in an Array
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] copy = new int[nums.length+1];        // copy[n] = {0};

        for(int ele : nums){
            if(copy[ele]!=0)        // checkking the index of element in nums is 0 in copy
                list.add(ele);
            else
                copy[ele] = ele;
        }
        return list;
    }
}
