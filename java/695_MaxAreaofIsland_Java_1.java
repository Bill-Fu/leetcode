class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        else {
            int result = 0;
            boolean[][] used = new boolean[grid.length][grid[0].length];
            
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == 1 && used[i][j] == false) {
                        int tmp = maxAreaOfIsland(grid, used, i, j);
                        if (tmp > result) {
                            result = tmp;
                        }
                    }
                }
            }
            
            return result;
        }
    }
    
    private int maxAreaOfIsland(int[][] grid, boolean[][] used, int m, int n) {
        if (m < 0 || n < 0 || m == grid.length || n == grid[0].length || grid[m][n] == 0 || used[m][n] == true) {
            return 0;
        }
        else {
            int result = 0;
            result++;
            
            used[m][n] = true;
            
            result += maxAreaOfIsland(grid, used, m - 1, n);
            result += maxAreaOfIsland(grid, used, m + 1, n);
            result += maxAreaOfIsland(grid, used, m, n - 1);
            result += maxAreaOfIsland(grid, used, m, n + 1);
            
            return result;
        }
    }
}
