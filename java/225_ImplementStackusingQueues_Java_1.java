class MyStack {
    Queue<Integer> queue;
    int size;
    
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new ArrayDeque<>();
        size = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        size++;
        
        for (int i = 0; i < size - 1; ++i) {
            queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        size--;
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
