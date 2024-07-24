// 202. Happy Number

/*
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            n = mySquare(n);
        }

        return n == 1;
        
        
        // int slow = n;
        // int fast = n;

        // do{
        //     slow = mySquare(slow);
        //     fast = mySquare(mySquare(fast));
        // } while(fast != slow);

        // if(slow == 1)
        //     return true;
        // return false;
    }
    private int mySquare(int num){
        int res = 0;
        while(num != 0){
            int rem = num % 10;
            res += rem * rem;
            num /= 10;
        }
        return res;
    }
}
