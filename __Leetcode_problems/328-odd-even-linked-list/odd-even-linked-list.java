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
    public ListNode oddEvenList(ListNode head) {
        if (head != null) {
    
            ListNode odd = head, even = head.next, evenHead = even; 
    
            while (even != null && even.next != null) {
                odd.next = odd.next.next; 
                even.next = even.next.next; 
                even = even.next;
                odd = odd.next;
            }
            odd.next = evenHead; 
        }
        return head;
    }
}

//  public ListNode oddEvenList(ListNode head) {
//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode temp = head;
//         while(temp!=null){
//             if(temp.next==null){
//                 temp.next = head.next;
//             }
//             temp.next=temp.next.next;     
//             temp = temp.next;
//         }
//         return head;
//     }