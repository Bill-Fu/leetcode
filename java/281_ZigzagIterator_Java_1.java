public class ZigzagIterator {
    Queue<Integer> queue;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new ArrayDeque<Integer>();
        
        if (v1.size() == 0) {
            for (int num: v2) {
                queue.add(num);
            }
        }
        else {
            int idx = 0;
            int pos = 0;
            
            for (int i = 0; i < v1.size() + v2.size(); ++i) {
                if (idx == 0) {
                    queue.add(v1.get(pos));
                    if (pos < v2.size()) {
                        idx = 1;
                    }
                    else {
                        pos++;
                    }
                }
                else {
                    queue.add(v2.get(pos));
                    if (pos + 1 < v1.size()) {
                        idx = 0;
                        pos++;
                    }
                    else {
                        pos++;
                    }
                }
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return queue.peek() != null;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
