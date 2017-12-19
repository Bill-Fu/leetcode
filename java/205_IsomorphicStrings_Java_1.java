class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] charArrS = s.toCharArray();
        char[] charArrT = t.toCharArray();
        
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> revmap = new HashMap<>();
        
        for (int i = 0; i < charArrS.length; ++i) {
            if (map.containsKey(charArrS[i])) {
                if (map.get(charArrS[i]) != charArrT[i]) {
                    return false;
                }
            }
            else if (revmap.containsKey(charArrT[i])) {
                return false;
            }
            else {
                map.put(charArrS[i], charArrT[i]);
                revmap.put(charArrT[i], charArrS[i]);
            }
        }
        
        return true;
    }
}
