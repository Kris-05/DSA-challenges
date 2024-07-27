// 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

/*
Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
*/

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {  
        if(head == null || head.next == null || head.next.next == null)
            return new int[]{-1, -1};
          
        ListNode prev = head;
        ListNode curr = null;
        ListNode post = null;

        int index = 2;
        int currPos = 0;
        int prevPos = -100000;
        int startPos = 0;
        int mindiff = 100000;

        do{
            curr = prev.next;
            post = curr.next;

            if((curr.val<prev.val && curr.val<post.val) || (curr.val>prev.val && curr.val>post.val)){
                currPos = index;
                mindiff = Math.min(mindiff, currPos - prevPos);
                prevPos = currPos;

                if(startPos == 0)
                    startPos = index; 
            }
            index++;
            prev = prev.next;
        }while(post.next != null);

        if(currPos == startPos)
            return new int[]{-1, -1}; 

        return new int[]{mindiff, currPos - startPos}; 
    }
}
