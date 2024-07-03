import java.util.Scanner;

/**
 * BinaryTree
 */
public class BinaryTree {

    public BinaryTree(){}

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root node");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to insert a node to left of " + node.value);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the node: ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to insert a node to right of " + node.value);
        boolean right = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the node: ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display(){
        display(root, "");
    }
    private void display(Node node, String indent){
        if(node!=null){
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t"); 
        display(node.right, indent + "\t"); 
    }
}
