class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        else {
            List<Integer> result = new ArrayList<>();
            char[] charArrP = p.toCharArray();
            char[] charArrS = s.toCharArray();
            int[] table = new int[26];
            
            for (int i = 0; i < charArrP.length; ++i) {
                table[charArrP[i] - 'a']--;
            }
            
            for (int i = 0; i < charArrS.length; ++i) {
                table[charArrS[i] - 'a']++;
                if (i >= charArrP.length) {
                    table[charArrS[i - charArrP.length] - 'a']--;
                }
                if (check(table) == true) {
                    result.add(i - charArrP.length + 1);
                }
            }
            
            return result;
        }
    }
    
    public boolean check(int[] table) {
        for (int i = 0; i < 26; ++i) {
            if (table[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
