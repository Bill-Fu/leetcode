class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        
        int i = 0;
        int j = word.length - 1;
        
        while (i < j) {
            char tmp = word[i];
            word[i] = word[j];
            word[j] = tmp;
            i++;
            j--;
        }
        
        return new String(word);
    }
}
