public class AVL {

    public class Node {
        private int height;
        private Node left;
        private Node right;
        private int value;
        
        public Node (int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }

    }
        public Node root;

        public AVL(){}

        public int getHeight(){
            return getHeight(root);
        }

        private int getHeight(Node node){
            if (node == null) {
                return -1;
            }
            return node.height;
        }

        public boolean isEmpty(){
            return root == null;
        }

        public void populate(int[] nums){
            for (int i = 0; i < nums.length; i++) {
                this.insert(nums[i]);
            }
        }

        public void insert(int value) {
            root = insert(value, root);
          }
        
          private Node insert(int value, Node node) {
            if (node == null) {
              node = new Node(value);
              return node;
            }
        
            if (value < node.value) {
              node.left = insert(value, node.left);
            }
        
            if (value > node.value) {
              node.right = insert(value, node.right);
            }
        
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            return rotate(node);
          }

          private Node rotate(Node node) {
            if (getHeight(node.left) - getHeight(node.right) > 1) {
              // left heavy
              if(getHeight(node.left.left) - getHeight(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
              }
              if(getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
              }
            }
        
            if (getHeight(node.left) - getHeight(node.right) < -1) {
              // right heavy
              if(getHeight(node.right.left) - getHeight(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
              }
              if(getHeight(node.right.left) - getHeight(node.right.right) > 0) {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
              }
            }
        
            return node;
          }

        public Node rightRotate(Node p) {
            Node c = p.left;
            Node t = c.right;
        
            c.right = p;
            p.left = t;
            
            p.height = Math.max(getHeight(p.left), getHeight(p.right) + 1);
            c.height = Math.max(getHeight(c.left), getHeight(c.right) + 1);
        
            return c;
          }

        // private Node rightRotate(Node p){
        //     Node c = p.left;
        //     Node t = c.right;

        //     c.right = p;
        //     p.left = t;

        //     p.height = Math.max(getHeight(p.left), getHeight(p.right) + 1);
        //     c.height = Math.max(getHeight(c.left), getHeight(c.right) + 1);

        //     return c;
        // }

        private Node leftRotate(Node c){
            Node p = c.right;
            Node t = p.left;

            p.left = c;
            c.right = t;

            p.height = Math.max(getHeight(p.left), getHeight(p.right) + 1);
            c.height = Math.max(getHeight(c.left), getHeight(c.right) + 1);

            return p;
        }

        public void populatedSorted(int[] nums) {
            populatedSorted(nums, 0, nums.length);
          }
        
          private void populatedSorted(int[] nums, int start, int end) {
            if (start >= end) {
              return;
            }
        
            int mid = (start + end) / 2;
        
            this.insert(nums[mid]);
            populatedSorted(nums, start, mid);
            populatedSorted(nums, mid + 1, end);
          }
        

        public boolean balanced() {
            return balanced(root);
          }
        
          private boolean balanced(Node node) {
            if (node == null) {
              return true;
            }
            return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
          }

        public void display() {
            display(this.root, "Root Node: ");
          }
        
          private void display(Node node, String details) {
            if (node == null) {
              return;
            }
            System.out.println(details + node.value);
            display(node.left, "Left child of " + node.value + " : ");
            display(node.right, "Right child of " + node.value + " : ");
          }

        public void preOrder(){
            preOrder(root);
        }
        private void preOrder(Node node){
            if(node == null){
                return;
            }
            System.out.println(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public void inOrder(){
            inOrder(root);
        }
        private void inOrder(Node node){
            if(node == null){
                return;
            }
            inOrder(node.left);
            System.out.println(node.value + " ");
            inOrder(node.right);
        }

        public void postOrder(){
            postOrder(root);
        }
        private void postOrder(Node node){
            if(node == null){
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value + " ");
        }
}