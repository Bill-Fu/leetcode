class Solution {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        
        for (int i = L; i <= R; ++i) {
            int cnt = 0;
            int num = i;
            
            while (num != 0) {
                cnt++;
                num = num & (num - 1);
            }
            
            switch(cnt) {
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
