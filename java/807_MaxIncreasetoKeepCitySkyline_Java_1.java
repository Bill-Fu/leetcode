class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result = 0;
        
        int[] leftRight = new int[grid.length];
        int[] topBottom = new int[grid[0].length];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                leftRight[i] = Math.max(leftRight[i], grid[i][j]);
                topBottom[j] = Math.max(topBottom[j], grid[i][j]);
            }
        }
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                result += (Math.min(leftRight[i], topBottom[j]) - grid[i][j]);
            }
        }
        
        return result;
    }
}
