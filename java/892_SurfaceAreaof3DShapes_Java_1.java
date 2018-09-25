class Solution {
    public int surfaceArea(int[][] grid) {
        int res = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] != 0) {
                    res += 2;
                }
                
                res += (i == 0? grid[i][j]: Math.max(0, grid[i][j] - grid[i - 1][j]));
                res += (i == grid.length - 1? grid[i][j]: Math.max(0, grid[i][j] - grid[i + 1][j]));
                res += (j == 0? grid[i][j]: Math.max(0, grid[i][j] - grid[i][j - 1]));
                res += (j == grid[i].length - 1? grid[i][j]: Math.max(0, grid[i][j] - grid[i][j + 1]));
            }
        }
        
        return res;
    }
}
