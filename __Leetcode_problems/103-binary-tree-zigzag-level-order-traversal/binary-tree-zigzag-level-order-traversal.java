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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        Deque<TreeNode> queue= new LinkedList<>();
        queue.addFirst(root);
        boolean reverse= false;

        while(!queue.isEmpty()){
            int levelSize= queue.size();
            List<Integer> currentLevel= new ArrayList<>();
            for(int i=0; i< levelSize; i++){
                if(!reverse){
                    TreeNode currentNode= queue.pollFirst();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left != null ){
                        queue.addLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.addLast(currentNode.right);
                    }
                }else{
                    TreeNode currentNode= queue.pollLast();
                    currentLevel.add(currentNode.val);
                    if(currentNode.right != null){
                        queue.addFirst(currentNode.right);
                    }
                    if(currentNode.left != null ){
                        queue.addFirst(currentNode.left);
                    }     
                }
            }   
            reverse = !reverse;
            ans.add(currentLevel);
        }
        return ans; 
    }
}