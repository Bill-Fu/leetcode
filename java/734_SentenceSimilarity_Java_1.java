class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        else {
            Map<String, Set<String>> map = new HashMap<>();
            
            for (int i = 0; i < pairs.length; ++i) {
                if (map.containsKey(pairs[i][0])) {
                    map.get(pairs[i][0]).add(pairs[i][1]);
                }
                else {
                    Set<String> set = new HashSet<>();
                    set.add(pairs[i][1]);
                    map.put(pairs[i][0], set);
                }
                
                if (map.containsKey(pairs[i][1])) {
                    map.get(pairs[i][1]).add(pairs[i][0]);
                }
                else {
                    Set<String> set = new HashSet<>();
                    set.add(pairs[i][0]);
                    map.put(pairs[i][1], set);
                }
            }
            
            for (int i = 0; i < words1.length; ++i) {
                if (words1[i].equals(words2[i]) == false && (map.containsKey(words1[i]) == false || map.get(words1[i]).contains(words2[i]) == false)) {
                    return false;
                }
            }
            
            return true;
        }
    }
}
