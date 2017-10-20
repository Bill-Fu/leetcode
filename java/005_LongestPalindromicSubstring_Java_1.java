class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        String result = s.substring(0, 1);
        int maxLen = 1;
        int j, k, tmpLen;
        
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tmpLen = 0;
                
                for (j = i; j < s.length() && (2 * i - j - 1) >= 0; j++) {
                    if (s.charAt(j) == s.charAt(2 * i - j - 1)) {
                        tmpLen += 2;
                    }
                    else {
                        break;
                    }
                }
                if (tmpLen > maxLen) {
                    maxLen = tmpLen;
                    result = s.substring(2 * i - j, j);
                }
            }
            
            tmpLen = 1;
            for (k = i + 1; k < s.length() && (2 * i - k) >= 0; ++k) {
                if (s.charAt(k) == s.charAt(2 * i - k)) {
                    tmpLen += 2;
                }
                else {
                    break;
                }
            }
            if (tmpLen > maxLen) {
                maxLen = tmpLen;
                result = s.substring(2 * i - k + 1, k);
            }
            
        }
        
        return result;
    }
}
