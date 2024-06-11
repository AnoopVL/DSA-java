/**
 * main
 */
public class main {

    public static void main(String[] args) {
        singleLL list = new singleLL();
        list.insertFirst(2);
        list.insertFirst(9);
        list.insertFirst(3);
        list.insertFirst(22);
        list.display();
        System.out.println();
        list.insertLast(8);
        list.display();
        System.out.println();
        list.insertAt(1, 3);
        list.display();
        System.out.println();
        // list.deleteFirst();
        // list.display();
        // System.out.println();
        // list.deleteLast();
        // list.display();
        System.out.println(list.deleteIndex(3));
        list.display();
    }
}