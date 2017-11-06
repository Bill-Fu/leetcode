class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] charArray = s.toCharArray();
        int start, end;
        start = 0;
        end = charArray.length - 1;
        
        while (start < end) {
            while (start < end && (charArray[start] <= 'z' && charArray[start] >= 'a' || charArray[start] <= '9' && charArray[start] >= '0') == false) {
                start++;
            }
            
            while (start < end && (charArray[end] <= 'z' && charArray[end] >= 'a' || charArray[end] <= '9' && charArray[end] >= '0') == false) {
                end--;
            }
            
            if (charArray[start] != charArray[end]) {
                return false;
            }
            else {
                start++;
                end--;
            }
        }
        
        return true;
    }
}
