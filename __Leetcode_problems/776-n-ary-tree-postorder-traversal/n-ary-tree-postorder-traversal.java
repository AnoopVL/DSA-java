/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
                if(root == null){
                    return result;
                }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            result.add(root.val);
            for(Node node: root.children){
                stack.push(node);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
// Yesterday's question for reference 
// public List<Integer> postorderTraversal(TreeNode root) {
//     List<Integer> result = new ArrayList<>();
//     Deque<TreeNode> stack = new ArrayDeque<>();
//     TreeNode p = root;
//     while (p != null || !stack.isEmpty()) {
//         if (p != null) {
//             result.add(p.val); 
//             stack.push(p);
//             p = p.right;
//         } else {
//             p = stack.pop();
//             p = p.left;
//         }
//     }
//     Collections.reverse(result);
//     return result;
// }
