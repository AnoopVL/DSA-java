import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // BinaryTree tree = new BinaryTree();
        // tree.populate(scanner);
        // // tree.display();
        // tree.prettyDisplay();

        BST bst = new BST();
        int[] nums = {15,10,20,5,12,8};
        bst.populate(nums);
        bst.display();
    }
}
