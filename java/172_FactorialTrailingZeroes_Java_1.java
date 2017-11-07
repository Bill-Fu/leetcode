class Solution {
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        else {
            int result = 0;
            while (n != 0) {
                n /= 5;
                result += n;
            }

            return result;
        }

    }
}
