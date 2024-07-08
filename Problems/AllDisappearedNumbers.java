// 448. Find All Numbers Disappeared in an Array
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int index = nums[i] - 1;
            if(nums[index] != nums[i])
                swap(nums,index,i);
            else
                i++;
        }
        for(i=0;i<nums.length;i++){
            if(i+1 != nums[i])
                list.add(i+1);
        }
    return list;
    }
    static void swap(int[] arr, int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
