/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        int count = 0;
        ListNode temp = head;
        // This is for counting the number of nodes
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count == n){
            return head.next;
        }
        int skipNode = count - n - 1;
        temp = head;
        
        for (int i = 0; i < skipNode; i++) {
            temp = temp.next;
        }
        
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        
        return head;
    }
}