class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int result = 0;
        int tmp = 1;
        
        while (a != 0 || b != 0 || carry != 0) {
            if ((((a & 1) ^ (b & 1)) ^ carry) == 1) {
                result += tmp;
            }
            if (((a & 1) & (b & 1)) == 1 || ((a & 1) & carry) == 1 || ((b & 1) & carry) == 1 ) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            tmp *= 2;
            a = a >>> 1;
            b = b >>> 1;
        }
        
        return result;
    }
}
