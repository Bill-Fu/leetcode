class LRUCache {
    int maxLen;
    int curLen;
    LinkNode head;
    LinkNode tail;
    Map<Integer, LinkNode> map;
    
    public LRUCache(int capacity) {
        maxLen = capacity;
        curLen = 0;
        head = new LinkNode(-1, -1);
        tail = new LinkNode(-2, -2);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            
            return node.val;
        }
        else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LinkNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            node = new LinkNode(key, value);
            
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            
            map.put(key, node);
        }
        else {
            if (curLen == maxLen) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;
                curLen--;
            }
            
            LinkNode node = new LinkNode(key, value);
            
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            curLen++;
            map.put(key, node);
        }
    }
}

class LinkNode {
    LinkNode next;
    LinkNode prev;
    int key;
    int val;
    
    public LinkNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
