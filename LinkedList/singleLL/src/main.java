/**
 * main
 */
public class main {

    public static void main(String[] args) {
        singleLL list = new singleLL();
        list.insertFirst(2);
        list.insertFirst(9);
        list.insertFirst(3);
        list.insertFirst(23);
        list.insertFirst(7);
        list.insertFirst(4);
        list.display();
        System.out.println();
        System.out.println("Using recusion: ");
        list.insertRec(4, 2);
        list.display();
        list.LLreverseRecuresion(list.head);
        System.out.println();
        list.display();
    }
}