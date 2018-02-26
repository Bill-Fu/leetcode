class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArrS = S.toCharArray();
        char[] charArrT = T.toCharArray();
        Character[] CharacterArrT = new Character[charArrT.length];
        
        for (int i = 0; i < charArrT.length; ++i) {
            CharacterArrT[i] = charArrT[i];
        }
        
        for (int i = 0; i < charArrS.length; ++i) {
            map.put(charArrS[i], i);
        }
        
        Arrays.sort(CharacterArrT, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                if (map.containsKey(c1) == true && map.containsKey(c2) == true) {
                    return map.get(c1) - map.get(c2);
                }
                else if (map.containsKey(c1) == false && map.containsKey(c2) == true) {
                    return -1;
                }
                else if (map.containsKey(c1) == true && map.containsKey(c2) == false) {
                    return 1;
                }
                else {
                    return c1.charValue() - c2.charValue();
                }
            }
        });
        
        for (int i = 0; i < charArrT.length; ++i) {
            charArrT[i] = CharacterArrT[i];
        }        
        return new String(charArrT);
    }
}
