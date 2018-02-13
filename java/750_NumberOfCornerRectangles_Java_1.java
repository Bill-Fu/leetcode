class Solution {
    public int countCornerRectangles(int[][] grid) {
        int result = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    for (int p = i + 1; p < grid.length; ++p) {
                        if (grid[p][j] == 1) {
                            for (int q = j + 1; q < grid[i].length; ++q) {
                                if (grid[i][q] == 1) {
                                    if (grid[p][q] == 1) {
                                        result++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
