/**
 * main
 */
public class main {

    public static void main(String[] args) {
        doubleLL doubleList = new doubleLL();
        doubleList.insertFirst(2);
        doubleList.insertFirst(9);
        doubleList.insertFirst(1);
        doubleList.display();
        // doubleList.displayReverse();
        doubleList.insertLast(2);
        doubleList.insertLast(7);
        doubleList.insertLast(4);
        doubleList.display();
        // doubleList.displayReverse();
        doubleList.insertAfter(8, 7);
        doubleList.display();
    }
}