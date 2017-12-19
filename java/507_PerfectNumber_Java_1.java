class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        else {
            int result = num;
            
            for (int i = 1; i <= Math.sqrt(num); ++i) {
                if (i != num && num % i == 0) {
                    result -= i;
                    if (num / i != i && num / i != num) {
                        result -= num / i;
                    }
                }
            }
            
            return result == 0;
        }
    }
}
