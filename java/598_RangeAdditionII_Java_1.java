class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;
        
        for (int i = 0; i < ops.length; ++i) {
            minM = Math.min(minM, ops[i][0]);
            minN = Math.min(minN, ops[i][1]);
        }
        
        return minM * minN;
    }
}
