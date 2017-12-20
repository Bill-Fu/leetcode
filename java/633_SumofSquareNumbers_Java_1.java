class Solution {
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; ++i) {
            if ((long) Math.pow((long)Math.sqrt(c - i * i), 2) + i * i == c) {
                return true;
            }
        }
        
        return false;
    }
}
