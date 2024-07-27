// 1550. Three Consecutive Odds

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int i=0; i<=arr.length-3; i++){
            if((arr[i]%2 == 1) && (arr[i+1]%2 == 1) && (arr[i+2]%2 == 1))
                return true;
        }

        return false;
    }
}
