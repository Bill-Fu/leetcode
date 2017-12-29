class Solution {
    public int countSubstrings(String s) {
        char[] charArr = s.toCharArray();
        int result = 0;
        
        for (int i = 0; i < charArr.length; ++i) {
            int left = i;
            int right = i;
            
            while (left >= 0 && right <= charArr.length - 1) {
                if (charArr[left--] == charArr[right++]) {
                    result++;
                }
                else {
                    break;
                }
            }
        }
        
        for (int i = 0; i < charArr.length - 1; ++i) {
            int left = i;
            int right = i + 1;
            
            while (left >= 0 && right <= charArr.length - 1) {
                if (charArr[left--] == charArr[right++]) {
                    result++;
                }
                else {
                    break;
                }
            }
        }
        
        return result;
    }
}
