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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx= findNode(root, x);
        TreeNode yy= findNode(root, y);

        return ((level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy)));      
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }
        TreeNode leftResult = findNode(node.left, x);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(node.right, x);
    }

    private boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy) {
        if (node == null) {
            return false;
        }
        return ((node.left == xx && node.right == yy) || (node.right == xx && node.left == yy)
                || isSibling(node.left, xx, yy) || isSibling(node.right, xx, yy));
    }

     private int level(TreeNode node, TreeNode target, int lev) {
        if (node == null) {
            return 0;
        }
        if (node == target) {
            return lev;
        }
        int leftLevel = level(node.left, target, lev + 1);
        if (leftLevel != 0) {
            return leftLevel;
        }
        return level(node.right, target, lev + 1);
    }
}