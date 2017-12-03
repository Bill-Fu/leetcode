class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int gPos = g.length - 1;
        int sPos = s.length - 1;
        int result = 0;
        
        while (gPos >= 0 && sPos >= 0) {
            if (s[sPos] >= g[gPos]) {
                result++;
                sPos--;
                gPos--;
            }
            else {
                gPos--;
            }
        }
        
        return result;
    }
}
