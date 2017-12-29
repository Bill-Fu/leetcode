class Solution {
    public int[][] candyCrush(int[][] board) {
        while (crush(board)) {
            drop(board);
        }
        
        return board;
    }
    
    public boolean crush(int[][] board) {
        boolean[][] crushed = new boolean[board.length][board[0].length];
        boolean sign = false;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0 && crush(board, i, j)) {
                    crushed[i][j] = true;
                    sign = true;
                }
            }
        }
        
        if (sign) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (crushed[i][j]) {
                        board[i][j] = 0;
                    }
                }
            }
        }
        
        return sign;
    }
    
    public void drop(int[][] board) {
        for (int j = 0; j < board[0].length; ++j) {
            int pos1 = board.length - 1;
            int pos2 = board.length - 1;
            
            while (pos2 >= 0) {
                if (board[pos2][j] == 0) {
                    pos2--;
                }
                else {
                    board[pos1][j] = board[pos2][j];
                    pos1--;
                    pos2--;
                }
            }
            
            while (pos1 >= 0) {
                board[pos1][j] = 0;
                pos1--;
            }
            
        }
    }
    
    public boolean crush(int[][] board, int m, int n) {
        if (m - 2 >= 0 && board[m - 1][n] == board[m][n] && board[m - 2][n] == board[m][n]) {
            return true;
        }
        if (m - 1 >= 0 && m + 1 <= board.length - 1 && board[m - 1][n] == board[m][n] && board[m + 1][n] == board[m][n]) {
            return true;
        }
        if (m + 2 <= board.length - 1 && board[m + 1][n] == board[m][n] && board[m + 2][n] == board[m][n]) {
            return true;
        }
        if (n - 2 >= 0 && board[m][n - 1] == board[m][n] && board[m][n - 2] == board[m][n]) {
            return true;
        }
        if (n - 1 >= 0 && n + 1 <= board[0].length - 1 && board[m][n - 1] == board[m][n] && board[m][n + 1] == board[m][n]) {
            return true;
        }
        if (n + 2 <= board[0].length - 1 && board[m][n + 1] == board[m][n] && board[m][n + 2] == board[m][n]) {
            return true;
        }
        
        return false;
    } 
}
