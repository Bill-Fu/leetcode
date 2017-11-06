class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        else if (haystack.length() == 0) {
            return -1;
        }
        else {
            char[] hay = haystack.toCharArray();
            char[] nee = needle.toCharArray();
            
            for (int i = 0; i <= hay.length - nee.length; ++i) {
                for (int j = 0; j < nee.length; ++j) {
                    if (nee[j] != hay[i + j]) {
                        break;
                    }
                    else {
                        if (j == nee.length - 1) {
                            return i;
                        }
                    }
                }
            }
            
            return -1;
        }
        
    }
}
