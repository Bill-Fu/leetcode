class Solution {
    public String reverseStr(String s, int k) {
        if (s.length() <= k) {
            String result = "";
            for (int i = 0; i < s.length(); ++i) {
                result = s.charAt(i) + result;
            }
            
            return result;
        }
        else if (s.length() <= 2 * k) {
            String result = "";
            for (int i = 0; i < k; ++i) {
                result = s.charAt(i) + result;
            }
            result += s.substring(k, s.length());
            return result;
        }
        else {
            return reverseStr(s.substring(0, 2 * k), k) + reverseStr(s.substring(2 * k, s.length()), k);
        }
    }
}
