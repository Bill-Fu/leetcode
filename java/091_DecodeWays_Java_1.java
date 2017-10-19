class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (i == 0 || Integer.parseInt(s.substring(i - 1, i + 1)) == 0 || Integer.parseInt(s.substring(i - 1, i + 1)) >=30) {
                    return 0;
                }
                else {
                    dp[i] = dp[i - 1];
                    dp[i + 1] = dp[i - 1];
                }    
            }
            else {
                if (i != 0 && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26 && Integer.parseInt(s.substring(i - 1, i + 1)) >= 10) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
                else {
                    dp[i + 1] = dp[i];
                }
            }
        }
        
        return dp[s.length()];
    }
}
