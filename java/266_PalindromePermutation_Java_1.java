class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < charArray.length; ++i) {
            if (map.containsKey(charArray[i])) {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            }
            else {
                map.put(charArray[i], 1);
            }
        }
        
        boolean sign = false;
        
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (sign) {
                    return false;
                }
                else {
                    sign = true;
                }
            }
        }
        
        return true;
    }
}
