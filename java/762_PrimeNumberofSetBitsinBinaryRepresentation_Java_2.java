class Solution {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        
        for (int i = L; i <= R; ++i) {
            switch(Integer.bitCount(i)) {
                case 2:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                case 17:
                case 19:
                    result++;
                    break;
            }
        }
        
        return result;
    }
}
