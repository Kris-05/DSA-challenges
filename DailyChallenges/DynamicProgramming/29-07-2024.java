// 1395. Count Number of Teams

/*
You have to form a team of 3 soldiers amongst them under the following rules:
Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).

Input: rating = [2,5,3,4,1]
Output: 3
Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1)
*/

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for(int i=1; i<n-1; i++){
            // pick the current element
            int middle = rating[i];
            int smallLeft = 0;
            int largeRight = 0;
            // to meet rating[left] < curr < rating[right]
            // check the elements smaller than curr in left
            for(int left=0; left<i; left++){
                if(rating[left] < middle)
                    smallLeft++;
            }
            // check the elements larger than curr in right
            for(int right=i+1; right<n; right++){
                if(middle < rating[right])
                    largeRight++;
            }
            // to find the total possibility we multiply
            count += (smallLeft * largeRight);

            // to meet rating[left] > curr > rating[right]
            int largeLeft = i - smallLeft;          // remaining elements in left will be larger
            int smallRight = n - i-1 - largeRight;  // remaining elements in right will be smaller

            // again find the total possibility
            count += (largeLeft * smallRight);
        }
        return count;
    }
}
