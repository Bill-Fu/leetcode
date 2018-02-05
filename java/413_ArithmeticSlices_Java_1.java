class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        else {
            int result = 0;
            int diff = A[1] - A[0];
            int cnt = 1;
            
            for (int i = 2; i < A.length; ++i) {
                if (A[i] - A[i - 1] == diff) {
                    result += cnt++;
                }
                else {
                    diff = A[i] - A[i - 1];
                    cnt = 1;
                }
            }
            
            return result;
        }
    }
}
