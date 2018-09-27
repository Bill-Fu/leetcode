class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        else {
            int sign = A[1] - A[0];
            
            for (int i = 2; i < A.length; ++i) {
                if (sign * (A[i] - A[i - 1]) < 0) {
                    return false;
                }
                else if (sign == 0 && (A[i] - A[i - 1] != 0)) {
                    sign = A[i] - A[i - 1];
                }
            }
            
            return true;
        }
    }
}
