class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        else {
            int left = (int) Math.log10(x);
            int right = 0;
            while (left > right) {
                if ((x / ((int)Math.pow(10, left))) % 10 != ((x / ((int) Math.pow(10, right))) % 10)) {
                    return false;
                }
                left--;
                right++;
            }
            
            return true;
        }
    }
}
