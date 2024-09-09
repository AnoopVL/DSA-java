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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int[] row: ans){
            Arrays.fill(row, -1);
        }
        int leftCol = 0, rightCol = n-1, topRow = 0, bottomRow = m-1;

        while (head != null){
            for(int col = leftCol; col <= rightCol && head != null; col++){
                ans[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;

            for(int row = topRow; row <= bottomRow && head != null; row++){
                ans[row][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;

            for(int col = rightCol; col >= leftCol && head != null; col--){
                ans[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

            for(int row = bottomRow; row >= topRow && head != null; row--){
                ans[row][leftCol] = head.val;
                head= head.next;
            }
            leftCol++;
        }
        return ans;
    }
}