//1342. Number of Steps to Reduce a Number to Zero
class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num != 0){
            if(num%2 != 0){
                num--;
                steps++;
            }
            else{
                num /= 2;
                steps++;
            } 
        }
        return steps;
    }
    // public int numberOfSteps(int num) {
    //     return stepsCount(num,0);
    // }
    // static int stepsCount(int n,int c){
    //     if(n == 0) return c;
    //     if(n%2 == 0) return stepsCount(n/2,++c);
    //     return stepsCount(n-1,++c);
    // }
}
