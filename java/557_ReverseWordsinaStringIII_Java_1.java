class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int min = 0;
        int max = 0;
        String result = "";
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == ' ') {
                max = i;
                result += reverseWords(charArray, min, max);
                result += " ";
                min = max + 1;
            }
        }
        
        max = charArray.length;
        result += reverseWords(charArray, min, max);
        
        return result;
    }
    
    private String reverseWords(char[] charArray, int min, int max) {
        String result = "";
        for (int i = max - 1; i >= min; --i) {
            result += charArray[i];
        }
        return result;
    }
}
