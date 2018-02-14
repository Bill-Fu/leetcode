class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.add(kill);
        
        for (int i = 0; i < ppid.size(); i++) {
            if (map.containsKey(ppid.get(i)) == false) {
                map.put(ppid.get(i), new ArrayList<>());
            }
            
            map.get(ppid.get(i)).add(pid.get(i));
        }
        
        while (queue.peek() != null) {
            result.add(queue.peek());
            if (map.containsKey(queue.peek())) {
                for (int id: map.get(queue.poll())) {
                    queue.add(id);
                }                
            }
            else {
                queue.poll();
            }
        }
        
        return result;
    }
}
