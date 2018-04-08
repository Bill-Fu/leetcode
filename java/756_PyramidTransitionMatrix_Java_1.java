class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<Character, Map<Character, Set<Character>>> map = new HashMap();
        
        for (String triple: allowed) {
            char X = triple.charAt(0);
            char Y = triple.charAt(1);
            char Z = triple.charAt(2);
            
            if (map.containsKey(X) == false) {
                map.put(X, new HashMap<>());
            }
            
            if (map.get(X).containsKey(Y) == false) {
                map.get(X).put(Y, new HashSet<>());
            }
            
            map.get(X).get(Y).add(Z);
        }
        
        return pyramidTransition(bottom.toCharArray(), new char[bottom.length() - 1], map, 0);
    }
    
    public boolean pyramidTransition(char[] bottom, char[] cur, Map<Character, Map<Character, Set<Character>>> map, int pos) {
        if (bottom.length == 1) {
            return true;
        }
        else if (cur.length == pos) {
            return pyramidTransition(cur, new char[cur.length - 1], map, 0);
        }
        else {
            if (map.containsKey(bottom[pos]) && map.get(bottom[pos]).containsKey(bottom[pos + 1])) {
                for (char c: map.get(bottom[pos]).get(bottom[pos + 1])) {
                    cur[pos] = c;
                    if (pyramidTransition(bottom, cur, map, pos + 1)) {
                        return true;
                    }
                }
                
                return false;
            }
            else {
                return false;
            }
        }
    }
}
