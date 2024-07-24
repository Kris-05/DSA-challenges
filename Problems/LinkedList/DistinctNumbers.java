//82. Remove Duplicates from Sorted List II

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head; 
        
        //create a dummy node before head for pointing prev node and set head to curr node
        ListNode res = new ListNode(0, head);
        ListNode temp = head;
        ListNode prev = res;
        
        while(temp != null){
            while(temp.next != null && temp.val == temp.next.val){
                temp = temp.next;
            } 
            if(prev.next == temp) {
                prev = prev.next;
            } else {
                prev.next = temp.next;
            }
            temp = temp.next;
        }
        return res.next;
    }
}
