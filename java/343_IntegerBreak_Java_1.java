class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return (n - 1);
        }
        else {
            int result = -1;
            
            for (int i = 2; i <= n / 2; ++i) {
                result = Math.max(result, (int)(Math.pow(n / i, i - n % i) * Math.pow(n / i + 1, n % i)));
            }
            
            return result;
        }
    }
}
