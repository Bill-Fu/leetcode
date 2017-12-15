class Solution {
    public int countSegments(String s) {
        char[] charArr = s.toCharArray();
        int result = 0;
        boolean sign = false;
        
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] == ' ') {
                if (sign) {
                    result++;
                    sign = false;
                }
            }
            else {
                sign = true;
            }
        }
        
        if (sign) {
            result++;
        }
        
        return result;
        
    }
}
