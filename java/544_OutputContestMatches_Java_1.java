class Solution {
    public String findContestMatch(int n) {
        String[] table = new String[n];
        
        for (int i = 0; i < n; ++i) {
            table[i] = String.valueOf(i + 1);
        }
        
        for (int i = (int)(Math.log10(n) / Math.log10(2)); i > 0; --i) {
            for (int j = 0; j < (int) Math.pow(2, i); ++j) {
                table[j] = "(" + table[j] + "," + table[((int) Math.pow(2, i)) - 1 - j] + ")";
            }
        }
        
        return table[0];
    }
}
