class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return A;
        }
        else {
            for (int i = 0; i < A.length; ++i) {
                for (int j = 0; j < A[i].length; ++j) {
                    A[i][j] = (A[i][j] + 1) % 2;
                }
            }
            
            for (int i = 0; i < A.length; ++i) {
                for (int j = 0; j < A[i].length / 2; ++j) {
                    int tmp = A[i][j];
                    A[i][j] = A[i][A[i].length - j - 1];
                    A[i][A[i].length - j - 1] = tmp;
                }
            }
            
            return A;
        }
    }
}
