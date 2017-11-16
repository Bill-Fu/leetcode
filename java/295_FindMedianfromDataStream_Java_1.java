class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>((x, y) -> y - x);
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (right.size() == 0) {
            right.add(num);
        }
        else {
            if (num > right.peek()) {
                right.add(num);
            }
            else {
                left.add(num);
            }
            
            if (right.size() - left.size() == 2) {
                left.add(right.poll());
            }
            else if (left.size() - right.size() == 1) {
                right.add(left.poll());
            }
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()) {
            return ((double)(left.peek() + right.peek()) / 2);
        }
        else {
            return right.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
