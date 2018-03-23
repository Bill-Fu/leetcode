class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int edge = 0;
        
        for (List<Integer> list: wall) {
            edge = 0;
            
            for (int len: list) {
                edge += len;
                
                map.put(edge, map.getOrDefault(edge, 0) + 1);
            }
        }
        
        map.remove(edge);
        
        for (int key: map.keySet()) {
            result = Math.max(result, map.get(key));
        }
        
        return wall.size() - result;
    }
}
