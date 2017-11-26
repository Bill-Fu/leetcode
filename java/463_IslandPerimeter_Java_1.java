class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] used = new boolean[grid.length][grid[0].length];
        int[] result = new int[1];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && used[i][j] == false) {
                    islandPerimeter(grid, used, result, i, j);
                    break;
                }
            }
        }
        
        return result[0];
    }
    
    private void islandPerimeter(int[][] grid, boolean[][] used, int[] result, int m, int n) {
        used[m][n] = true;
        if (m == 0 || grid[m - 1][n] == 0) {
            result[0]++;
        }
        else if (used[m - 1][n] == false) {
            islandPerimeter(grid, used, result, m - 1, n);
        }
        
        if (m == grid.length - 1 || grid[m + 1][n] == 0) {
            result[0]++;
        }
        else if (used[m + 1][n] == false) {
            islandPerimeter(grid, used, result, m + 1, n);
        }
        
        if (n == 0 || grid[m][n - 1] == 0) {
            result[0]++;
        }
        else if (used[m][n - 1] == false) {
            islandPerimeter(grid, used, result, m, n - 1);
        }
        
        if (n == grid[0].length - 1 || grid[m][n + 1] == 0) {
            result[0]++;
        }
        else if (used[m][n + 1] == false) {
            islandPerimeter(grid, used, result, m, n + 1);
        }        
    }
}
