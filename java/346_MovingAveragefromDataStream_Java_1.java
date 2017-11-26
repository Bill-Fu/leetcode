class MovingAverage {
    
    Queue<Integer> queue;
    int size;
    int maxSize;
    int sum;
    
    /** Initialize your data structure here. */
    public MovingAverage(int maxSize) {
        this.queue = new ArrayDeque<>();
        this.size = 0;
        this.maxSize = maxSize;
        this.sum = 0;
    }
    
    public double next(int val) {
        if (maxSize == 0) {
            return 0;
        }
        else {
            if (size == maxSize) {
                sum -= queue.poll();
                size--;
            }
            sum += val;
            queue.add(val);
            size++;
            return ((double) sum) / size;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
