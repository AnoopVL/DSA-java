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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = Integer.MAX_VALUE, last = 0, prev_val = head.val, min_d = Integer.MAX_VALUE;
        for(int i = 0; head.next != null; i++){
            // if(prev_val < head.val > head.next.val || prev_val > head.val < head.next.val){
            if((prev_val < head.val && head.val > head.next.val) || (prev_val > head.val && head.val < head.next.val)){
                if(last !=0){
                    min_d = Math.min(min_d, i-last);
                }
                first = Math.min(first, i);
                last = i;
            }   
            prev_val = head.val;
            head = head.next;
        }
        if(min_d == Integer.MAX_VALUE){
            return new int[] {-1,-1};
        }
        return new int[] {min_d, last - first};
    }
}