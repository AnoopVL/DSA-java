import java.util.LinkedList;
import java.util.Queue;




public class LvlOdrScsr {
    public static void main(String[] args) {
        
    }

    public static TreeNode levelOrderSuccessor(TreeNode root, int key){
        // TreeNode result = new TreeNode();
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
            
        }
        return queue.peek();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
