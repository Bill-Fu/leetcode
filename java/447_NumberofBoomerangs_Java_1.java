class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        
        for (int i = 0; i < points.length; ++i) {
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = 0; j < points.length; ++j) {
                int dist = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (map.containsKey(dist)) {
                    map.put(dist, map.get(dist) + 1);
                }
                else {
                    map.put(dist, 1);
                }
            }
            
            for (int key : map.keySet()) {
                result += map.get(key) * (map.get(key) - 1);
            }
        }
        
        return result;
    }
}
