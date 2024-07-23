//1636. Sort Array by Increasing Frequency

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency,
sort them in decreasing order.

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
*/

class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] temp = new Integer[n];

        for(int i=0; i<=n-1; i++){
            //key -> nums[i]; value -> frequency
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
            temp[i] = nums[i];   
        }
        
        //since "Integer" is a object & hashMap or ArrayList expects object we use wrapper class
        Arrays.sort(temp, (a,b) -> {
            //to return the frequency in incresing order
            if(map.get(a) != map.get(b))
                return map.get(a) - map.get(b);
            //to return the number in decsending order if frequency is same
            else
                return b - a;
        });

        //to convert Integer array to int array
        for(int i=0; i<n; i++)
            nums[i] = temp[i];

        return nums;
    }
}
