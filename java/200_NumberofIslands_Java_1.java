class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        else {
            boolean use[][] = new boolean[grid.length][grid[0].length];
            int result = 0;
            
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == '1' && use[i][j] == false) {
                        result++;
                        numIslands(i, j, grid, use);
                    }
                }
            }
            
            return result;
        }
    }
    
    private void numIslands(int m, int n, char[][] grid, boolean[][] use) {
        if (m >= 0 && m < grid.length && n >= 0 && n < grid[0].length) {
            if (grid[m][n] == '1' && use[m][n] == false) {
                use[m][n] = true;
                numIslands(m - 1, n, grid, use);
                numIslands(m + 1, n, grid, use);
                numIslands(m, n - 1, grid, use);
                numIslands(m, n + 1, grid, use);
            }
        }
    }
}
