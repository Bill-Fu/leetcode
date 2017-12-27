class Solution {
    public String findContestMatch(int n) {
        String[] table = new String[n];
        
        for (int i = 0; i < n; ++i) {
            table[i] = String.valueOf(i + 1);
        }
        
        for (; n > 1; n /= 2) {
            for (int i = 0; i < n; ++i) {
                table[i] = "(" + table[i] + "," + table[n - 1 - i] + ")";
            }
        }
        
        return table[0];
    }
}
