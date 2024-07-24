//2191. Sort the Jumbled Numbers

/*
Input: mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
Output: [338,38,991]
Explanation: 
Map the number 991 as follows:
1. mapping[9] = 6, so all occurrences of the digit 9 will become 6.
2. mapping[1] = 9, so all occurrences of the digit 1 will become 9.
Therefore, the mapped value of 991 is 669.
338 maps to 007, or 7 after removing the leading zeros.
38 maps to 07, which is also 7 after removing leading zeros.
Since 338 and 38 share the same mapped value, they should remain in the same relative order, so 338 comes before 38.
Thus, the sorted array is [338,38,991].
*/

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int temp = nums[i];
            int mappedNum = temp == 0 ? mapping[0] : 0;
            int place = 1;
            while(temp > 0){
                int rem = temp % 10;
                mappedNum += place * mapping[rem];
                place *= 10;
                temp /= 10;
            }
            list.add(new int[]{nums[i], mappedNum, i});
        }

        // If both Mapped nums are equal then sort based on their index else sort the mappedNums
        list.sort((a,b) -> {
            if(a[1] == b[1])
                return a[2] - b[2];
            else
                return a[1] - b[1];
        });
        
        // Here list(i)[0] -> Original num
        // list(i)[1] -> mappedNum of original num
        // list(i)[2] -> index of nums
        for(int i=0; i<n; i++){
            nums[i] = list.get(i)[0];
        }

        return nums;
    }
}
