class Trie {
    Map<Character, Trie> map;
    Set<Character> table;
    
    /** Initialize your data structure here. */
    public Trie() {
        map = new HashMap<>();
        table = new HashSet<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 1) {
            if (map.containsKey(word.charAt(0)) == false) {
                map.put(word.charAt(0), null);
            }
            table.add(word.charAt(0));
        }
        else {
            if (map.containsKey(word.charAt(0)) == true && map.get(word.charAt(0)) != null) {
                map.get(word.charAt(0)).insert(word.substring(1, word.length()));
            }
            else {
                map.put(word.charAt(0), new Trie());
                map.get(word.charAt(0)).insert(word.substring(1, word.length()));
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 1) {
            return table.contains(word.charAt(0));
        }
        else {
            if (map.containsKey(word.charAt(0)) == true && map.get(word.charAt(0)) != null) {
                return map.get(word.charAt(0)).search(word.substring(1, word.length()));
            }
            else {
                return false;
            }
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 1) {
            return map.containsKey(prefix.charAt(0));
        }
        else {
            if (map.containsKey(prefix.charAt(0)) == true && map.get(prefix.charAt(0)) != null) {
                return map.get(prefix.charAt(0)).startsWith(prefix.substring(1, prefix.length()));
            }
            else {
                return false;
            }
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
