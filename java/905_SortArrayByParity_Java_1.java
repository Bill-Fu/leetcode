class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        
        int start = 0;
        int end = A.length - 1;
        
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                res[start++] = A[i];
            }
            else {
                res[end--] = A[i];
            }
        }
        
        return res;
    }
}
