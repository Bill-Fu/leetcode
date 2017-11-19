class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<String>();
        }
        else {
            TrieNode root = new TrieNode();
            Set<String> resSet = new HashSet<>();
            boolean[][] used = new boolean[board.length][board[0].length];
            
            for (int i = 0; i < words.length; ++i) {
                root.insertWord(words[i]);
            }
            
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    findWords(board, root, used, i, j, resSet, "");
                }
            }
            
            return new ArrayList<String>(resSet);
        }
        
    }
    
    public void findWords(char[][] board, TrieNode root, boolean[][] used, int m, int n, Set<String> resSet, String cur) {
        if (root.map.containsKey(board[m][n])) {
            used[m][n] = true;
            if (root.map.get(board[m][n]).isWord) {
                resSet.add(cur + board[m][n]);
            }
            if (m > 0 && used[m - 1][n] == false) {
                findWords(board, root.map.get(board[m][n]), used, m - 1, n, resSet, cur + board[m][n]);
            }
            if (m < board.length - 1 && used[m + 1][n] == false) {
                findWords(board, root.map.get(board[m][n]), used, m + 1, n, resSet, cur + board[m][n]);
            }
            if (n > 0 && used[m][n - 1] == false) {
                findWords(board, root.map.get(board[m][n]), used, m, n - 1, resSet, cur + board[m][n]);
            }
            if (n < board[0].length - 1 && used[m][n + 1] == false) {
                findWords(board, root.map.get(board[m][n]), used, m, n + 1, resSet, cur + board[m][n]);
            }

            used[m][n] = false;
        }
    }
}

class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> map;
    
    public TrieNode() {
        isWord = false;
        map = new HashMap<>();
    }
    
    public void insertWord(String newWord) {
        if (newWord.length() == 0) {
            isWord = true;
        }
        else {
            if (map.containsKey(newWord.charAt(0))) {
                map.get(newWord.charAt(0)).insertWord(newWord.substring(1, newWord.length()));
            }
            else {
                TrieNode TN = new TrieNode();
                map.put(newWord.charAt(0), TN);
                TN.insertWord(newWord.substring(1, newWord.length()));
            }
        }
    }
}
