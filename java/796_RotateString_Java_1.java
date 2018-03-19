class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        else if (A.length() == 0) {
            return true;
        }
        else {
            for (int i = 0; i < A.length(); ++i) {
                A = A.substring(1, A.length()) + A.charAt(0);
                
                if (A.equals(B)) {
                    return true;
                }
            }
            
            return false;
        }
    }
}
