class Solution {
    public void rotate(int[][] matrix) {
        int i, j, k, n, tmp, p, q;
        
        n = matrix.length;
        
        for (i = 0; i < (n+1)/2; ++i) {
            for (j = 0; j < n/2; ++j) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
}
