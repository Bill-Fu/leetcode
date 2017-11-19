class Solution {
    public boolean isMatch(String s, String p) {
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        
        if (isMatch(charS, charP, 0, 0)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isMatch(char[] charS, char[] charP, int sPos, int pPos) {
        if (sPos == charS.length && pPos == charP.length) {
            return true;
        }
        else if (sPos > charS.length) {
            return false;
        }
        else if (sPos < charS.length && pPos == charP.length) {
            return false;
        }
        else {
            switch (charP[pPos]) {
                case '.':
                    if (pPos + 1 == charP.length || charP[pPos + 1] != '*') {
                        return isMatch(charS, charP, sPos + 1, pPos + 1);
                    }
                    else {
                        for (int i = sPos - 1; i < charS.length; ++i) {
                            if (isMatch(charS, charP, i + 1, pPos + 2)) {
                                return true;
                            }
                        }
                        
                        return false;
                    }
                case '*':
                    return false;
                default:
                    if (pPos + 1 == charP.length || charP[pPos + 1] != '*') {
                        if (sPos != charS.length && charS[sPos] == charP[pPos]) {
                            return isMatch(charS, charP, sPos + 1, pPos + 1);
                        }
                        else {
                            return false;
                        }                        
                    }
                    else {
                        if (isMatch(charS, charP, sPos, pPos + 2)) {
                            return true;
                        }
                        
                        for (int i = sPos; i < charS.length; ++i) {
                            if (charS[i] == charP[pPos]) {
                                if (isMatch(charS, charP, i + 1, pPos + 2)) {
                                    return true;
                                }
                            }
                            else {
                                break;
                            }
                        }
                        return false;
                    }
            }
        }
    }
}
