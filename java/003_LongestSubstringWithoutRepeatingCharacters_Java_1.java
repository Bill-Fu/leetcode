class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> table = new HashMap<>();
        int result = 0, tmp = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            if (table.containsKey(s.charAt(i)) == true) {
                if (i - table.get(s.charAt(i)) <= tmp) {
                    if (tmp > result) {
                        result = tmp;
                    }
                    tmp = i - table.get(s.charAt(i));
                    table.put(s.charAt(i), i);
                }
                else {
                    tmp++;
                    table.put(s.charAt(i), i);
                }
            }
            else {
                tmp++;
                table.put(s.charAt(i), i);
            }
        }
        
        if (tmp > result) {
            result = tmp;
        }
        
        return result;
    }
}
