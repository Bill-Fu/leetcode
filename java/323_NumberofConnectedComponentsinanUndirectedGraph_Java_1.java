class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> connection = new HashMap<>();
        
        for (int i = 0; i < edges.length; ++i) {
            if (connection.containsKey(edges[i][0]) == false) {
                connection.put(edges[i][0], new HashSet<>());
            }
            connection.get(edges[i][0]).add(edges[i][1]);
            
            if (connection.containsKey(edges[i][1]) == false) {
                connection.put(edges[i][1], new HashSet<>());
            }
            connection.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] used = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        int result = 0;
        
        for (int i = 0; i < n; ++i) {
            if (used[i] == false) {
                used[i] = true;
                
                queue.add(i);
                
                while (queue.peek() != null) {
                    if (connection.containsKey(queue.peek())) {
                        for (int node: connection.get(queue.peek())) {
                            if (used[node] == false) {
                                used[node] = true;
                                queue.add(node);
                            }
                        }                        
                    }
                    
                    queue.poll();
                }
                
                result++;
            }
        }
        
        return result;
    }
}
