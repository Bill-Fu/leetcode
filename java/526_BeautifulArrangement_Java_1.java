class Solution {
    int result;
    public int countArrangement(int N) {
        result = 0;
        
        boolean[] used = new boolean[N + 1];
        
        countArrangement(N, used);
        
        return result;
    }
    
    public void countArrangement(int N, boolean[] used) {
        if (N == 0) {
            result++;
        }
        else {
            for (int i = 1; i < used.length; ++i) {
                if ((N % i == 0 || i % N == 0) && used[i] == false) {
                    used[i] = true;
                    countArrangement(N - 1, used);
                    used[i] = false;
                }
            }
        }
    }
}
