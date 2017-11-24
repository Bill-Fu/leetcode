class Solution {
    public String reverseWords(String s) {
        char[] charArray = s.toCharArray();
        int min = 0;
        int max = 0;
        
        for (int i = 0; i < charArray.length; ++i) {
            if (charArray[i] == ' ') {
                max = i - 1;
                
                while (min < max) {
                    char tmp = charArray[min];
                    charArray[min] = charArray[max];
                    charArray[max] = tmp;
                    min++;
                    max--;
                }
                
                min = i + 1;
            }
        }
        
        
        max = charArray.length - 1;
        while (min < max) {
            char tmp = charArray[min];
            charArray[min] = charArray[max];
            charArray[max] = tmp;
            min++;
            max--;
        }
        
        return new String(charArray);
    }
}
