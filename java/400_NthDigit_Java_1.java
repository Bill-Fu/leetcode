class Solution {
    public int findNthDigit(int n) {
        long size = 9;
        int len = 1;
        long cur = 0;
        
        while (n - len * size > 0) {
            n -= len * size;
            cur += size;
            size *= 10;
            len++;
        }
        
        cur += (n - 1) / len + 1;
        n = (n - 1) % len + 1;
        
        return String.valueOf(cur).charAt(n - 1) - '0';
    }
}
