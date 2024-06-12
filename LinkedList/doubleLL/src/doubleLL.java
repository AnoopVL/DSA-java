/**
 * doubleLL
 */
public class doubleLL {

    Node head;
    Node tail;

    private class Node{
        int value;
        Node next; 
        Node prev;

        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head!=null) {
            head.prev = node; 
        }
        head = node;
    }

    public void insertLast(int value){
        Node temp = head;
        Node node = new Node(value);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.prev = temp;
        node.next = null;
        tail = node;
    }

    public void insertAfter(int value, int after){
        Node previous = find(after);
        Node node = new Node(value);
        if (previous == null) {
            System.out.println("Node not found !");
        }
        node.next = previous.next;
        previous.next = node;
        node.prev = previous;
        if(node.next == null){
            insertLast(value);
        }
        node.next.prev = node;
    }

    public Node find(int value){
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void display(){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println("");
    }
    public void displayReverse(){
        Node temp = head;
        Node last = null ;
        while (temp!=null) {
            // System.out.print(node.value + " -> ");
            last = temp;
            temp = temp.next;
        }
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }
        System.out.print("START");
        System.out.println("");
    }
}