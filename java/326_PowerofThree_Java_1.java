class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        else {
            return Math.pow(3, (int)(Math.log10(n) / Math.log10(3))) == n;            
        }
    }
}
