class HitCounter {
    Queue<Integer> queue;
    int count;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new ArrayDeque<>();
        count = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        while (queue.peek() != null && queue.peek() <= timestamp - 300) {
            queue.poll();
            count--;
        }
        queue.add(timestamp);
        count++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (queue.peek() != null && queue.peek() <= timestamp - 300) {
            queue.poll();
            count--;
        }
        
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
