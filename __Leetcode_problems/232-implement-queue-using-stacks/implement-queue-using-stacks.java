class MyQueue {
    ArrayList<Integer> queue;
    public MyQueue() {
        queue = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        queue.add(x);
    }
    
    public int pop() {
        return queue.remove(0);
    }
    
    public int peek() {
        return queue.get(0);
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */