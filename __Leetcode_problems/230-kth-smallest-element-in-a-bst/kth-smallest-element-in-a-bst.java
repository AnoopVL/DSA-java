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
    int count= 0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }

    private TreeNode helper(TreeNode node, int k){
        if(node == null){
            return null;
        }
        TreeNode left = helper(node.left, k);

        if(left != null){
            return left;
        }
        count++;

        if(count == k){
            return node;
        }
        return helper(node.right, k);
    }
}