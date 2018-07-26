class KthLargest {
    PriorityQueue<Integer> queue;
    int size;
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        size = k;
        
        for (int i = 0; i < k && i < nums.length; ++i) {
            queue.add(nums[i]);
        }
        
        for (int i = k; i < nums.length; ++i) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if (queue.size() < size) {
            queue.add(val);
        }
        else {
            if (val > queue.peek()) {
                queue.poll();
                queue.add(val);
            }            
        }
        
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
