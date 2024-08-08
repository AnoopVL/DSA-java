/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head== null){
            return null;
        }
        HashMap<Node, Node> oldToNew= new HashMap<>();
        Node current= head;
        // 1st iteration to add all the node in hashMap
        while(current != null){
            oldToNew.put(current, new Node(current.val));
            current= current.next;
        }
        current = head;
        //2nd iteration to fix all the next and random pointers in the map
        while(current!= null){
            oldToNew.get(current).next = oldToNew.get(current.next);
            oldToNew.get(current).random = oldToNew.get(current.random);
            current= current.next;
        }
        return oldToNew.get(head);
    }
}