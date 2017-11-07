class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        else {
            long min = 1;
            long max = x;
            long m;
            
            while (true) {
                m = (max + min) / 2;

                if (m * m <= x && (m + 1) * (m + 1) > x) {
                    return (int) m;
                }
                else if (m * m > x) {
                    max = m - 1;
                }
                else {
                    min = m + 1;
                }
            }        
        }

    }
}
