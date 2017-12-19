class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] table = new boolean[26];
        
        for (char letter: letters) {
            table[letter - 'a'] = true;
        }
        
        for (int i = target - 'a' + 1; i < 26; ++i) {
            if (table[i]) {
                return (char) (i + 'a');
            }
        }
        
        for (int i = 0; i < 26; ++i) {
            if (table[i]) {
                return (char) (i + 'a');
            }
        }
        
        return 'a';
    }
}
