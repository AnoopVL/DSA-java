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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode node = head;
        while(node.next != null){
            ListNode temp = gcd(node.val, node.next.val);
            temp.next = node.next;
            node.next = temp;
            node = temp.next;
        }
        return head;
    }
    private ListNode gcd(int a, int b){
        if(b == 0){
            return new ListNode(a);
        }
        return gcd(b, a%b);
    }
}