public class SegmentTree {
    public class  Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node (int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    Node root;

    public SegmentTree(int[] arr){
        this.root = constructTree(arr, 0, arr.length-1);
    }
    private Node constructTree(int[] arr, int start, int end){
        if (start == end) {
            // we are at the leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = start + (end - start)/2;

        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str = "";
        // display the left child
        if (node.left != null) {
            str = str + "Interval = [ " + node.left.startInterval+" - "+ node.left.endInterval + " ] data = " + node.left.data + " +=>";
        }else{
            str = str + "No left child";
        }
        // display the node
        str = str + "Interval = [ " + node.startInterval+" - "+ node.endInterval + " ] data = " + node.data + " +=>";
        // display right child
        if (node.right != null) {
            str = str + "Interval = [ " + node.right.startInterval+" - "+ node.right.endInterval + " ] data = " + node.right.data + " +=>";
        }else{
            str = str + "No right child";
        }

        System.out.println(str);

        if (node.left != null) {
            display(node.left);
        }
        if (node.right != null) {
            display(node.right);
        }
    }

    public int query(int qsi, int qei){
        return this.query(this.root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei) {
        if(node.startInterval >= qsi && node.endInterval <= qei) {
          // node is completely lying inside query
          return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
          // completely outside
          return 0;
        } else {
          return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    // update
    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startInterval&& index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }
}
