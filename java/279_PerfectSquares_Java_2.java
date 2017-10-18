class Solution {
    public int numSquares(int n) {
        int[] table = new int[n + 1];
        
        Arrays.fill(table, Integer.MAX_VALUE);
        
        table[0] = 0;
        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; i - j * j >= 0; ++j) {
                if (table[i - j * j] + 1 < table[i]) {
                    table[i] = table[i - j * j] + 1;
                }
            }
        }
        
        return table[n];
    }
}
