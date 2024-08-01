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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead= new ListNode(0);
        ListNode tail= dummyHead;
        int carryOver=0;

        while(l1 != null || l2 != null || carryOver!=0){
            int first= (l1 != null)? l1.val : 0;
            int second= (l2 != null)? l2.val : 0;
            int sum= first+ second+carryOver;
            int digit = sum % 10;
            carryOver = sum/10;
            
            ListNode temp= new ListNode(digit);
            tail.next= temp;
            tail= tail.next;

            l1 = (l1!=null)? l1.next : null;
            l2 = (l2!=null)? l2.next : null;
        }
        return dummyHead.next;

    }
}