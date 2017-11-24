class Logger {
    Queue<String> queue;
    Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public Logger() {
        queue = new ArrayDeque<>();
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (queue.peek() != null && map.get(queue.peek()) <= timestamp - 10) {
            map.remove(queue.peek());
            queue.poll();
        }
        
        if (map.containsKey(message)) {
            return false;
        }
        else {
            map.put(message, timestamp);
            queue.add(message);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
