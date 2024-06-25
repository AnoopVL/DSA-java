/**
 * singleLL
 */
public class singleLL {

    public Node head;
    public Node tail;
    public int size;
    public singleLL(){
        this.size = 0;
    }

    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if (index == 0) {
            Node tempNode = new Node(val, node);
            size++;
            return tempNode;
        }
        node.next = insertRec(val, index-1, node.next);
        // node.next = insertRec(val, index--, node.next); If we use index--, it throws nullpointer error
        return node;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAt(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
    }

    public int deleteFirst(){
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return head.value;
    }

    public int deleteLast(){
        if (size <=1) {
           return deleteFirst();
        }
        Node secondLast = get(size - 1);
        int val = tail.value;
        tail = secondLast;
        secondLast.next = null;
        size--;
        return val;
    }

    public int deleteIndex(int index){
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node prev = get(index -1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void LLreverseRecuresion(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        LLreverseRecuresion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int val){
            this.value = val;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}