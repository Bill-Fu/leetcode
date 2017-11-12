class Solution {
    public int firstUniqChar(String s) {
        int[] table = new int[26];
        char[] charArray = s.toCharArray();
        
        Arrays.fill(table, -2);
        
        for (int i = 0; i < charArray.length; ++i) {
            if (table[charArray[i] - 'a'] == -2) {
                table[charArray[i] - 'a'] = i;
            }
            else {
                table[charArray[i] - 'a'] = -1;
            }
        }
        
        int result = Integer.MAX_VALUE;
        
        for (int i = 0; i < 26; ++i) {
            if (table[i] != -2 && table[i] != -1) {
                if (table[i] < result) {
                    result = table[i];
                }
            }
        }
        
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return result;
        }
    }
}
