class Solution {
    public int[][] imageSmoother(int[][] M) {
        int result[][] = new int[M.length][M[0].length];
        int i, j, k, n, sum = 0, count = 0;
        
        for (i = 0; i < M.length; ++i) {
            for (j = 0; j < M[0].length; ++j) {
                sum = 0;
                count = 0;
                for (k = -1; k < 2; ++k) {
                    for (n = -1; n < 2; ++n) {
                        if ((i+k) >= 0 && (i+k) < M.length && (j+n) >= 0 && (j+n) < M[0].length) {
                            sum+=M[i+k][j+n];
                            count++;
                        }
                    }
                }
                result[i][j] = sum/count;
            }
        }
        
        return result;
    }
}
