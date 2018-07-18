class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder SB_S = new StringBuilder();
        StringBuilder SB_T = new StringBuilder();
        
        for (char c: S.toCharArray()) {
            if (c == '#' && SB_S.length() != 0) {
                SB_S.deleteCharAt(SB_S.length() - 1);
            }
            else if (c != '#') {
                SB_S.append(c);
            }
        }
        
        for (char c: T.toCharArray()) {
            if (c == '#' && SB_T.length() != 0) {
                SB_T.deleteCharAt(SB_T.length() - 1);
            }
            else if (c != '#') {
                SB_T.append(c);
            }
        }
        
        return SB_S.toString().equals(SB_T.toString());
    }
}
