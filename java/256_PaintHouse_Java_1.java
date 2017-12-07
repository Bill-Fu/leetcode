class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        else {
            int[][] results = new int[costs.length][costs[0].length];
            
            results[0][0] = costs[0][0];
            results[0][1] = costs[0][1];
            results[0][2] = costs[0][2];
            
            for (int i = 1; i < costs.length; ++i) {
                results[i][0] = costs[i][0] + Math.min(results[i - 1][1], results[i - 1][2]);
                results[i][1] = costs[i][1] + Math.min(results[i - 1][0], results[i - 1][2]);
                results[i][2] = costs[i][2] + Math.min(results[i - 1][0], results[i - 1][1]);
            }
            
            return Math.min(results[results.length - 1][0], Math.min(results[results.length - 1][1], results[results.length - 1][2]));
        }
    }
}
