class Solution {
    public int maxA(int N) {
        if (N < 6) {
            return N;
        }
        else {
            int[] dp = new int[N + 1];
            int[] cp = new int[N + 1];       
            
            for (int i = 1; i < 6; ++i) {
                dp[i] = i;
                cp[i] = 1;
            }
            
            for (int i = 6; i <= N; ++i) {
                dp[i] = dp[i - 5] * 4;
                cp[i] = dp[i - 5];
                
                if (dp[i - 4] * 3 >= dp[i]) {
                    dp[i] = dp[i - 4] * 3;
                    cp[i] = dp[i - 4];
                }
                
                if (dp[i - 3] * 2 >= dp[i]) {
                    dp[i] = dp[i - 3] * 2;
                    cp[i] = dp[i - 3];
                }
                
                if (dp[i - 2] + 2 * cp[i - 2] > dp[i]) {
                    dp[i] = dp[i - 2] + 2 * cp[i - 2];
                    cp[i] = cp[i - 2];
                }
                
                if (dp[i - 1] + cp[i - 1] > dp[i]) {
                    dp[i] = dp[i - 1] + cp[i - 1];
                    cp[i] = cp[i - 1];
                }
            }
            
            return dp[N];
        }
    }
}
