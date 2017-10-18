class Solution {
    public int numSquares(int n) {
        int[] table = new int[n + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        
        for (int i = 1; i < n + 1; ++i) {
            if (Math.pow((int) Math.sqrt(i), 2 )== i) {
                table[i] = 1;
            }
            else {
                for (int j = 1; j <= i / 2; ++j) {
                    if (table[j] + table[i - j] < table[i]) {
                        table[i] = table[j] + table[i - j];
                    }
                }
            }
        }
        
        return table[n];
    }
}
