class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
       traverse(root.left, root.right, 1);
       return root;
    }

    private void traverse(TreeNode node1, TreeNode node2, int level){
        if(node1 == null || node2 == null) return;
        if(level %2 == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        traverse(node1.left, node2.right, level+1);
        traverse(node1.right, node2.left, level+1);
    }

}
