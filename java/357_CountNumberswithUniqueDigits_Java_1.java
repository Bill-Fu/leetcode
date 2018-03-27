class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int result = 1;        
        int count = 9;

        for (int i = 1; i <=n && i < 10; ++i) {
            result += count;
            count *= (10 - i);
        }
        
        return result;
    }
}
