//88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n -1;
        int k = m+n -1; // last index 
        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];    //check from last of nums1 since it is sorted
            else
                nums1[k--] = nums2[j--];    //check from last of nums2 since it is sorted
        }
    }
}
