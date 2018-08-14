class Solution {
    public int projectionArea(int[][] grid) {
        int res = 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid.length];
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] != 0) {
                    res++;
                }
                
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        
        for (int i = 0; i < row.length; ++i) {
            res += row[i];
        }
        
        for (int j = 0; j < col.length; ++j) {
            res += col[j];
        }
        
        return res;
    }
}
