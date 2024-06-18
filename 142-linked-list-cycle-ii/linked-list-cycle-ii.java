/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = lengthOfCycle(slow);
                break;
            }
        }
        if(length == 0){
            return null;
        }
// we initiate first and second pointer to find the common point
        ListNode first = head;
        ListNode second = head;

        while (length>0){
            second = second.next;
            length--;
        }
// Keep moving forward till they meet at the start of cycle
        while(first != second){
            second= second.next;
            first = first.next;
        }
        return first;

    }
    public int lengthOfCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int length = 0;
                ListNode temp = slow;
                do{
                    temp = temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return 0;
    }
}