// 1460. Make Two Arrays Equal by Reversing Subarrays

/*
You are given two integer arrays of equal length target and arr. In one step, you can select any non-empty subarray of arr and reverse it. You are allowed to 
make any number of steps. Return true if you can make arr equal to target or false otherwise.
*/

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele : target)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        
        for(int ele : arr){
            if(map.get(ele) == null)
                return false;
            map.put(ele, map.get(ele)-1);
            if(map.get(ele) == 0)
                map.remove(ele);
        }
        return map.size() == 0;
    }
}
