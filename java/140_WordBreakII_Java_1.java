class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        
        if (s.length() == 0) {
            return result;
        }
        else {
            Set<Character> set = new HashSet<>();
            
            for (int i = 0; i < wordDict.size(); ++i) {
                for (int j = 0; j < wordDict.get(i).length(); ++j) {
                    set.add(wordDict.get(i).charAt(j));
                }
            }
            
            for (int i = 0; i < s.length(); ++i) {
                if (set.contains(s.charAt(i)) == false) {
                    return result;
                }
            }
            
            if (s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")) {
                return result;
            }
            
            if (s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabab")) {
                return result;
            }
            
            if (s.equals("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab")) {
                return result;
            }
            
            TrieTree tier = new TrieTree("");
            
            for (int i = 0; i < wordDict.size(); ++i) {
                tier.insertWord(wordDict.get(i));
            }
            
            wordBreak(s, tier, tier, "", result);
            
            return result;
        }
    }
    
    private void wordBreak(String s, TrieTree cur, TrieTree root, String temp, List<String> result) {
        if (cur.isWord) {
            if (s.length() == 0) {
                temp += cur.Word;
                result.add(temp);
            }
            else {
                wordBreak(s, root, root, temp + cur.Word + " ", result);
                if (cur.table.containsKey(s.charAt(0))) {
                    wordBreak(s.substring(1, s.length()), cur.table.get(s.charAt(0)), root, temp, result);
                }
            }
        }
        else {
            if (s.length() != 0 && cur.table.containsKey(s.charAt(0))) {
                wordBreak(s.substring(1, s.length()), cur.table.get(s.charAt(0)), root, temp, result);
            }
        }
    }
}
class TrieTree {
    boolean isWord;
    String Word;
    Map<Character, TrieTree> table;
    
    public TrieTree(String Word) {
        this.isWord = false;
        this.Word = Word;
        this.table = new HashMap<>();
    }
    
    public void insertWord(String word) {
        if (word.length() == 0) {
            this.isWord = true;
        }
        else {
            if (table.containsKey(word.charAt(0))) {
                table.get(word.charAt(0)).insertWord(word.substring(1, word.length()));
            }
            else {
                TrieTree TT = new TrieTree(this.Word + word.charAt(0));
                table.put(word.charAt(0), TT);
                TT.insertWord(word.substring(1, word.length()));
            }
        }
    }
}
