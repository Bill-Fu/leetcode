class Solution {
    public int binaryGap(int N) {
        int res = 0;
        
        while (N != 0) {
            if (N % 2 == 0) {
                N /= 2;
            }
            else {
                N /= 2;
                break;
            }
        }
        
        int step = 1;
        
        while (N != 0) {
            if (N % 2 == 1) {
                res = Math.max(step, res);
                step = 0;
            }
            
            step++;
            N /= 2;
        }
        
        return res;
    }
}
