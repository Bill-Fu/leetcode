class Solution {
    public char findTheDifference(String s, String t) {
        char[] charArrS = s.toCharArray();
        char[] charArrT = t.toCharArray();
        int result = 0;
        
        for (int i = 0; i < charArrT.length; ++i) {
            result += charArrT[i] - 'a';
        }
        
        for (int i = 0; i < charArrS.length; ++i) {
            result -= charArrS[i] - 'a';
        }
        
        return (char)('a' + result);
    }
}
