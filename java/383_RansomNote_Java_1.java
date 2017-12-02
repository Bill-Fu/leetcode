class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ranArr = ransomNote.toCharArray();
        char[] magArr = magazine.toCharArray();
        
        int[] table = new int[26];
        
        for (char ch : magArr) {
            table[ch - 'a']++;
        }
        
        for (char ch : ranArr) {
            table[ch - 'a']--;
        }
        
        for (int times : table) {
            if (times < 0) {
                return false;
            }
        }
        
        return true;
    }
}
