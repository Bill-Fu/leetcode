class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new ArrayDeque();
        int visited_cnt = 1;
        
        visited[0] = true;
        queue.add(0);
        
        while (queue.peek() != null) {
            int cur = queue.poll();
            
            for (int room: rooms.get(cur)) {
                if (visited[room] == false) {
                    visited[room] = true;
                    queue.add(room);
                    visited_cnt++;
                }
            }
        }
        
        return visited_cnt == rooms.size();
    }
}
