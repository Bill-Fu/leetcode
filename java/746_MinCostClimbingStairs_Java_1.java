class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length + 2];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        
        result[0] = result[1] = 0;
        
        for (int i = 0; i < cost.length; ++i) {
            result[i + 1] = Math.min(result[i + 1], result[i] + cost[i]);
            result[i + 2] = Math.min(result[i + 2], result[i] + cost[i]);
        }
        
        return result[cost.length];
    }
}
