/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int sum){
        if(node== null){
            return 0;
        }
        sum = sum*10 + node.val;

        if(node.right==null && node.left==null){
            return sum;
        }

        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
    }
}