class MinStack {
    Stack<Integer> minVal;
    Stack<Integer> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        minVal = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (minVal.empty() == true) {
            minVal.push(x);
        }
        else if (x < minVal.peek()) {
            minVal.push(x);
        }
        else {
            minVal.push(minVal.peek());
        }
    }
    
    public void pop() {
        stack.pop();
        minVal.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minVal.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
