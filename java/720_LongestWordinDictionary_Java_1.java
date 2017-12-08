class Solution {
    public String longestWord(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], false);
        }
        
        String result = "";
        
        for (String s: map.keySet()) {
            longestWord(s, map);
            if (map.get(s)) {
                if (s.length() > result.length() || s.length() == result.length() && result.compareTo(s) > 0) {
                    result = s;
                }
            }
        }
        
        return result;
    }
    
    public void longestWord(String s, Map<String, Boolean> map) {
        if (s.length() == 1) {
            map.put(s, true);
        }
        else {
            if (map.containsKey(s.substring(0, s.length() - 1))) {
                if (map.get(s.substring(0, s.length() - 1)) == false) {
                    longestWord(s.substring(0, s.length() - 1), map);                    
                }
                if (map.get(s.substring(0, s.length() - 1))) {
                    map.put(s, true);
                }
            }
            else {
                map.put(s, false);
            }
        }
    }
}
