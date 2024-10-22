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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            long levelSum = 0;
            for(int i =0; i < levelSize; i++){
                TreeNode current = queue.poll();
                levelSum += (long) current.val;
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            pq.add(levelSum);
        }
        if(pq.size() < k){
            return -1;
        }
        for(int i=0; i< k-1; i++){
            pq.poll();
        }
        return pq.peek();

    }
}