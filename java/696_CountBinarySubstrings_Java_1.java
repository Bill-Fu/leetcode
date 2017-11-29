class Solution {
    public int countBinarySubstrings(String s) {
        char[] charArr = s.toCharArray();
        
        if (charArr.length < 2) {
            return 0;
        }
        else {
            int cur = charArr[0];
            int numPrev = 0;
            int numNext = 0;
            int result = 0;
            
            for (int i = 0; i < charArr.length; ++i) {
                if (charArr[i] == cur) {
                    numNext++;
                }
                else {
                    result += Math.min(numPrev, numNext);
                    numPrev = numNext;
                    cur = charArr[i];
                    numNext = 1;
                }
            }
            
            result += Math.min(numPrev, numNext);
            
            return result;
        }
        
    }
}
