class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        cur.add(0);
        
        allPathsSourceTarget(graph, cur, result);
        
        return result;
    }
    
    public void allPathsSourceTarget(int[][] graph, List<Integer> current, List<List<Integer>> result) {
        if (current.get(current.size() - 1) == graph.length - 1) {
            result.add(current);
        }
        else {
            for (int i = 0; i < graph[current.get(current.size() - 1)].length; ++i) {
                List<Integer> cur = new ArrayList<>(current);
                cur.add(graph[current.get(current.size() - 1)][i]);
                allPathsSourceTarget(graph, cur, result);
            }
        }
    }
}
