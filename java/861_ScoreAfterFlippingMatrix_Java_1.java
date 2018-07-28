class Solution {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; ++i) {
            if (A[i][0] != 1) {
                for (int j = 0; j < A[i].length; ++j) {
                    A[i][j] = (A[i][j] + 1) % 2;
                }
            }
        }
        
        int res = 0;
        for (int j = 0; j < A[0].length; ++j) {
            int cnt = 0;
            
            for (int i = 0; i < A.length; ++i) {
                if (A[i][j] == 1) {
                    cnt++;
                }
            }
            
            if (cnt >= (A.length + 1) / 2) {
                res = res * 2 + cnt;
            }
            else {
                res = res * 2 + (A.length - cnt);
            }
        }
        
        return res;
    }
}
