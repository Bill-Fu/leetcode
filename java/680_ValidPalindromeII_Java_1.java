class Solution {
    public boolean validPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int left = 0;
        int right = charArr.length - 1;
        
        while (left < right) {
            if (charArr[left] == charArr[right]) {
                left++;
                right--;
            }
            else {
                return check(charArr, left + 1, right) || check(charArr, left, right - 1);
            }
        }
        
        return true;
        
    }
    
    public boolean check(char[] charArr, int start, int end) {
        while (start < end) {
            if (charArr[start++] != charArr[end--]) {
                return false;
            }
        }
        
        return true;
    }
}
