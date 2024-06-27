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
    public int pairSum(ListNode head) {
        if(head==null || head.next == null){
            return head.val;
        }
        ListNode fast = head;
        ListNode slow = head;
        int maxSum = 0;

        // find the middle node
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse till mid
        ListNode prev = slow;
        slow = slow.next;
        prev.next = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        } 
        // add the twins and compare
        ListNode first = head;
        ListNode last = prev;
        while(last!=null){
            maxSum = Math.max(maxSum, (first.val+last.val));
            first = first.next;
            last = last.next;
        }
        System.gc();
        return maxSum;      
    }
}