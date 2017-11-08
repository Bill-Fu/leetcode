class Solution {
    public int reverse(int x) {
        long result = 0;
        long X;
        
        if (x < 0) {
            X = -(long)x;
        }
        else {
            X = (long)x;
        }
        
        while (X != 0) {
            result = 10 * result + X % 10;
            X = X / 10;
        }
        
        if (x < 0) {
            result = -result;
        }
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        else {
            return (int)result;
        }
        
    }
}
