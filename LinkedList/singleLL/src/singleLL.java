/**
 * singleLL
 */
public class singleLL {

    private Node head;
    private Node tail;
    private int size;
    public singleLL(int size){
        this.size = size;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}