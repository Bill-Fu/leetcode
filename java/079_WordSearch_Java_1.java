class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] table = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (exist(board, table, word, i, j) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean exist(char[][] board, boolean[][] table, String word, int m, int n) {
        if (word.isEmpty() == true) {
            return true;
        }
        else {
            if (table[m][n] == false && board[m][n] == word.charAt(0)) {
                if (word.length() == 1) {
                    return true;
                }
                
                table[m][n] = true;
                
                if (m - 1 >= 0) {
                    if (exist(board, table, word.substring(1), m - 1, n)) {
                        return true;
                    }
                }
                
                if (m + 1 <= board.length - 1) {
                    if (exist(board, table, word.substring(1), m + 1, n)) {
                        return true;
                    }
                }
                
                if (n - 1 >= 0) {
                    if (exist(board, table, word.substring(1), m, n - 1)) {
                        return true;
                    }
                }
                
                if (n + 1 <= board[0].length - 1) {
                    if (exist(board, table, word.substring(1), m, n + 1)) {
                        return true;
                    }
                }
                
                table[m][n] = false;
                
                return false;
            }
            else {
                return false;
            }
        }
    }
}
