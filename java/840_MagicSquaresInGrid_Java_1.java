class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        
        for (int i = 0; i < grid.length - 2; ++i) {
            for (int j = 0; j < grid[0].length - 2; ++j) {
                boolean[] table = new boolean[9];
                for (int p = 0; p < 3; ++p) {
                    for (int q = 0; q < 3; ++q) {
                        if (grid[i + p][j + q] <= 9 && grid[i + p][j + q] >= 1) {
                            table[grid[i + p][j + q] - 1] = true;
                        }
                    }
                }
                
                int n;
                for (n = 0; n < 9; ++n) {
                    if (table[n] == false) {
                        break;
                    }
                }
                if (n != 9) {
                    continue;
                }
                
                int tmp = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != tmp) {
                    continue;
                }
                if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != tmp) {
                    continue;
                }
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != tmp) {
                    continue;
                }
                if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != tmp) {
                    continue;
                }
                if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != tmp) {
                    continue;
                }
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != tmp) {
                    continue;
                }
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != tmp) {
                    continue;
                }
                
                res++;
            }
        }
        
        return res;
    }
}
