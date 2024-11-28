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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases.
        dummy.next = head;
        ListNode preSlow = dummy; // Start with dummy as the "previous" node.
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            // Move `fast` pointer forward to skip duplicates.
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }

            if (slow.next == fast) { // No duplicates for the current node.
                preSlow = slow;
                slow = fast;
            } else { // Duplicates were found, skip them.
                preSlow.next = fast;
                slow = fast; // Update `slow` to the next unique node.
            }
        }

        return dummy.next; // Return the new head (dummy.next).
    }
}