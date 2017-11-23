class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        
        for (int i = 0; i < 31; ++i) {
            if (x % 2 != y % 2) {
                result++;
            }
            x /= 2;
            y /= 2;
        }
        
        return result;
    }
}
