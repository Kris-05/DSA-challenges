// Two ways to solve the starting position of cycle
// To find the length of the cycle

// 142. Linked List Cycle II

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        /*
        Set<ListNode> set = new HashSet<>();

        ListNode temp = head;
        while(temp != null){
            if(!set.contains(temp)){
                set.add(temp);
                temp = temp.next;
            }else 
                return temp;
        }

        return null;
        */

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
            //MODEL 1 : To find the start of the loop
                //Intialize slow to head and increment at same speed
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
            //MODEL 2 : To find the length of loop
                //Initialize a temp pointer to slow and move one by one until it reaches again
                // ListNode temp = slow;
                // int length = 0;
                // do{
                //     temp = temp.next;
                //     length++;
                // } while (temp != slow);
                // System.out.println(length);
                return slow;
            }
        }
        return null;
    }
}
