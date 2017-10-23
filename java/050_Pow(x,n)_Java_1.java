class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        else {
            if (x == 0.0) {
                return 0.0;
            }
            else if (x == 1.0) {
                return 1.0;
            }
            else if (x == -1.0) {
                if (n % 2 == 0) {
                    return 1.0;
                }
                else {
                    return -1.0;
                }
            }
            else {
                double result = 1;
                
                if (n > 0) {
                    for (int i = 0; i < n; ++i) {
                        result *= x;
                        if (result == 0.0 || result == 1.0) {
                            return result;
                        }
                    }
                }
                else {
                    for (int i = 0; i > n; --i) {
                        result /= x;
                        if (result == 0.0 || result == 1.0) {
                            return result;
                        }
                    }
                }
                
                return result;
            }
        }
    }
}
