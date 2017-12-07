class Solution {
    public int longestPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int[] lowerTable = new int[26];
        int[] upperTable = new int[26];
        int result = 0;
        boolean sign = false;
        
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] - 'a' >= 0 && charArr[i] - 'a' < 26) {
                lowerTable[charArr[i] - 'a']++;
            }
            else {
                upperTable[charArr[i] - 'A']++;
            }
        }
        
        for (int i = 0; i < lowerTable.length; ++i) {
            if (lowerTable[i] % 2 == 0) {
                result += lowerTable[i];
            }
            else {
                sign = true;
                result += lowerTable[i] - 1;
            }
        }
        
        for (int i = 0; i < upperTable.length; ++i) {
            if (upperTable[i] % 2 == 0) {
                result += upperTable[i];
            }
            else {
                sign = true;
                result += upperTable[i] - 1;
            }
        }
        
        return sign ? (result + 1) : result;
    }
}
