class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        String result = "";
        String tmp = "";
        
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == ' ') {
                result += tmp;
                result += ' ';
                tmp = "";
            }
            else {
                tmp = charArray[i] + tmp;
            }
        }
        
        result += tmp;
        
        return result;
    }
}
