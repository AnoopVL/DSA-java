public class TreeValidPath {
    public static void main(String[] args) {
        
    }

    public static boolean treeValidPath(TreeNode root, int[] path){
        if(root == null){
            return false;
        }
        return treeValidPath(root, path, 0);
    }

    private static boolean treeValidPath(TreeNode node, int[] path, int index){
        if(node == null){
            return false;
        }
        if(node.val!= path[index] || index >= path.length){
            return false;
        }
        if(node.val == path[index] && node.left==null && node.right==null && index == path.length-1){
             return true;
        }
        return treeValidPath(node.left, path, index+1) || treeValidPath(node.right, path, index+1);
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