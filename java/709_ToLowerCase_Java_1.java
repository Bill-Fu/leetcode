class Solution {
    public String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        
        StringBuilder SB = new StringBuilder();
        
        for (char c: charArray) {
            SB.append(toLowerCaseChar(c));
        }
        
        return new String(SB);
    }
    
    public char toLowerCaseChar(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c - 'A' + 'a');
        }
        else {
            return c;
        }
    }
}
