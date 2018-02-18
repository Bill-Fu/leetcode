class MagicDictionary {
    TierTree root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TierTree();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s: dict) {
            root.insert(s);
        }        
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return root.magicSearch(word);
    }
}

class TierTree {
    Map<Character, TierTree> map;
    boolean isWord;
    
    public TierTree() {
        map = new HashMap<>();
        isWord = false;
    }
    
    public void insert(String s) {
        if (s.length() == 0) {
            isWord = true;
        }
        else {
            if (map.containsKey(s.charAt(0)) == false) {
                map.put(s.charAt(0), new TierTree());
            }
            
            map.get(s.charAt(0)).insert(s.substring(1, s.length()));
        }
    }
    
    public boolean search(String s) {
        if (s.length() == 0) {
            return isWord;
        }
        else {
            if (map.containsKey(s.charAt(0)) == false) {
                return false;
            }
            else {
                return map.get(s.charAt(0)).search(s.substring(1, s.length()));
            }
        }
    }
    
    public boolean magicSearch(String s) {
        if (s.length() == 0) {
            return false;
        }
        else {
            for (char c: map.keySet()) {
                if (c == s.charAt(0)) {
                    if (map.get(c).magicSearch(s.substring(1, s.length())) == true) {
                        return true;
                    }
                }
                else {
                    if (map.get(c).search(s.substring(1, s.length())) == true) {
                        return true;
                    }
                }
            }
            
            return false;
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
