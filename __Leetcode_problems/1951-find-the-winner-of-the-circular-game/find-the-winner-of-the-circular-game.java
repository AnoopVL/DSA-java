class Solution {
    public int findTheWinner(int n, int k) {
        // Initialize linkedlist
        LinkedList<Integer> members = new LinkedList<>();
        for(int i = 1; i<= n ; i++){
            members.add(i);
        }
        int lastRemoved = 0;
        // Start the game
        for(int i =0; i < n; i++){
            for(int j = 1; j <= k -1; j++){
                // remove the elements and add them to last of the linkedlist
                members.add(members.poll());
            }
            lastRemoved = members.poll();
        }
        System.gc();
        return lastRemoved;
    }
}