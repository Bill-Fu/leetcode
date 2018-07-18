class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] charArrS = S.toCharArray();
        char[] charArrT = T.toCharArray();
        
        int cnt;
        int posS = charArrS.length - 1;
        int posT = charArrT.length - 1;
        
        while (posS > -1 || posT > -1) {
            cnt = 0;
            while (posS > -1 && (charArrS[posS] == '#' || cnt != 0)) {
                if (charArrS[posS] == '#') {
                    cnt++;
                }
                else {
                    cnt--;
                }
                posS--;
            }
            cnt = 0;
            while (posT > -1 && (charArrT[posT] == '#' || cnt != 0)) {
                if (charArrT[posT] == '#') {
                    cnt++;
                }
                else {
                    cnt--;
                }
                posT--;
            }
            
            if (posS != -1 && posT != -1) {
                if (charArrS[posS] != charArrT[posT]) {
                    return false;
                }
                posS--;
                posT--;
            }
            else if (posS != -1 && posT == -1 || posS == -1 && posT != -1) {
                return false;
            }
        }
        
        return true;
    }
}
