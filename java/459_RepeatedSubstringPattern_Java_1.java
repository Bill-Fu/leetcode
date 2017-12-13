class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }
        else {
            for (int i = 1; i <= s.length() / 2; ++i) {
                if (s.length() % i == 0) {
                    int j;
                    for (j = 1; j < s.length() / i; ++j) {
                        if (s.substring(0, i).equals(s.substring(i * j, i * j + i)) == false) {
                            break;
                        }
                    }
                    if (j == s.length() / i) {
                        return true;
                    }
                }
            }
            
            return false;
        }
    }
}
