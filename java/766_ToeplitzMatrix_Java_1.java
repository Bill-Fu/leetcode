class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            int m = i;
            int n = 0;
            
            while (++m < matrix.length && ++n < matrix[0].length) {
                if (matrix[m][n] != matrix[m - 1][n - 1]) {
                    return false;
                }
            }
        }
        
        for (int j = 1; j < matrix[0].length; ++j) {
            int m = 0;
            int n = j;
            
            while (++m < matrix.length && ++n < matrix[0].length) {
                if (matrix[m][n] != matrix[m - 1][n - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
