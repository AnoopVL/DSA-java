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
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
         if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root1);
        queue2.offer(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) return false;

            if (node1.left != null && node2.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            } else if (node1.left != node2.left) {
                return false; 
            }

            if (node1.right != null && node2.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            } else if (node1.right != node2.right) {
                return false; 
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();

     }
}