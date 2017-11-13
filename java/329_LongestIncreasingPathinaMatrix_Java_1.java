class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        else {
            int[][] table = new int[matrix.length][matrix[0].length];
            int result = 0;
            
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if ((i == 0 || matrix[i - 1][j] >= matrix[i][j]) && (i == matrix.length - 1 || matrix[i + 1][j] >= matrix[i][j]) && (j == 0 || matrix[i][j - 1] >= matrix[i][j]) && (j == matrix[0].length - 1 || matrix[i][j + 1] >= matrix[i][j])) {
                        table[i][j] = 1;
                    }
                }
            }
            
            for (int i = 0; i < table.length; ++i) {
                for (int j = 0; j < table[0].length; ++j) {
                    longestIncreasingPath(matrix, table, i, j);
                }
            }
            
            for (int i = 0; i < table.length; ++i) {
                for (int j = 0; j < table[0].length; ++j) {
                    if (table[i][j] > result) {
                        result = table[i][j];
                    }
                }
            }
            
            return result;
        }
    }
    
    private void longestIncreasingPath(int[][] matrix, int[][] table, int m, int n) {
        if (m != 0 && matrix[m - 1][n] > matrix[m][n] && table[m][n] + 1 > table[m - 1][n]) {
            table[m - 1][n] = table[m][n] + 1;
            longestIncreasingPath(matrix, table, m - 1, n);
        }
        if (n != 0 && matrix[m][n - 1] > matrix[m][n] && table[m][n] + 1 > table[m][n - 1]) {
            table[m][n - 1] = table[m][n] + 1;
            longestIncreasingPath(matrix, table, m, n - 1);
        }
        if (m != matrix.length - 1 && matrix[m + 1][n] > matrix[m][n] && table[m][n] + 1 > table[m + 1][n]) {
            table[m + 1][n] = table[m][n] + 1;
            longestIncreasingPath(matrix, table, m + 1, n);
        }
        if (n != matrix[0].length - 1 && matrix[m][n + 1] > matrix[m][n] && table[m][n] + 1 > table[m][n + 1]) {
            table[m][n + 1] = table[m][n] + 1;
            longestIncreasingPath(matrix, table, m, n + 1);            
        }
    }
}
