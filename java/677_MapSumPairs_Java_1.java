class MapSum {

    TierTree TT;
    /** Initialize your data structure here. */
    public MapSum() {
        TT = new TierTree();
    }
    
    public void insert(String key, int val) {
        TT.insert(key, val);
    }
    
    public int sum(String prefix) {
        TierTree pref = TT.value(prefix);
        
        if (pref == null) {
            return 0;
        }
        else {
            return pref.sum();
        }
    }
}

class TierTree {
    Map<Character, TierTree> map;
    int cnt;
    
    public TierTree() {
        map = new HashMap<>();
        cnt = 0;
    }
    
    public void insert(String key, int val) {
        if (key.equals("") == true) {
            cnt = val;
        }
        else {
            if (map.containsKey(key.charAt(0)) == false) {
                map.put(key.charAt(0), new TierTree());
            }
            
            map.get(key.charAt(0)).insert(key.substring(1, key.length()), val);
        }
    }
    
    public TierTree value(String prefix) {
        if (prefix.length() == 1) {
            return map.getOrDefault(prefix.charAt(0), null);
        }
        else {
            if (map.containsKey(prefix.charAt(0))) {
                return map.get(prefix.charAt(0)).value(prefix.substring(1, prefix.length()));
            }
            else {
                return null;
            }
        }
    }
    
    public int sum() {
        int result = cnt;
        
        for (Map.Entry<Character, TierTree> entry: map.entrySet()) {
            result += entry.getValue().sum();
        }
        
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
