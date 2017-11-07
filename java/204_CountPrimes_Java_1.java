class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        else {
            boolean[] table = new boolean[n];
            int result = 0;
            
            table[0] = true;
            table[1] = true;
            
            for (int i = 2; i < table.length; ++i) {
                if (table[i] == false) {
                    result++;
                    for (int j = 2; i * j < table.length; ++j) {
                        table[i * j] = true;
                    }
                }
            }
            
            return result;
        }
    }
}
