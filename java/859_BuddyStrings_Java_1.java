class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() == B.length()) {
            int[] diff = new int[2];
            int cnt = 0;
            
            char[] charArrA = A.toCharArray();
            char[] charArrB = B.toCharArray();
            int[] table = new int[26];
            
            for (int i = 0; i < charArrA.length; ++i) {
                table[charArrA[i] - 'a']++;
                if (charArrA[i] != charArrB[i]) {
                    if (cnt >= 2) {
                        return false;
                    }
                    else {
                        diff[cnt++] = i;
                    }
                }
            }
            
            if (cnt == 0) {
                for (int i = 0; i < 26; ++i) {
                    if (table[i] > 1) {
                        return true;
                    }
                }
                
                return false;
            }
            else if (cnt == 1) {
                return false;
            }
            else {
                if (charArrA[diff[0]] == charArrB[diff[1]] && charArrA[diff[1]] == charArrB[diff[0]]) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            return false;
        }
    }
}
