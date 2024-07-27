//2181. Merge Nodes in Between Zeros

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode l1 = new ListNode(0);
        ListNode res = l1;
        while(head.next != null){
            ListNode temp = head.next;
            int sum = 0;
            while(temp.val != 0){
                sum += temp.val;
                temp = temp.next;
            }
            ListNode newNode = new ListNode(sum);
            l1.next = newNode;
            l1 = l1.next;

            head = temp;
        }
        l1.next = null;
        return res.next;
    }
}
