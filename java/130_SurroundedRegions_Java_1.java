class Solution {
    public void solve(char[][] board) {
        if (board.length != 0 && board[0].length != 0) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            
            for (int i = 0; i < board[0].length; ++i) {
                if (board[0][i] == 'O' && visited[0][i] == false) {
                    search(board, visited, 0, i);
                }
            }
            
            for (int i = 0; i < board[0].length; ++i) {
                if (board[board.length - 1][i] == 'O' && visited[board.length - 1][i] == false) {
                    search(board, visited, board.length - 1, i);
                }
            }
            
            for (int i = 0; i < board.length; ++i) {
                if (board[i][0] == 'O' && visited[i][0] == false) {
                    search(board, visited, i, 0);
                }
            }
            
            for (int i = 0; i < board.length; ++i) {
                if (board[i][board[0].length - 1] == 'O' && visited[i][board[0].length - 1] == false) {
                    search(board, visited, i, board[0].length - 1);
                }
            }
            
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[0].length; ++j) {
                    if (board[i][j] == 'O' && visited[i][j] == false) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    
    private void search(char[][] board, boolean[][] visited, int m, int n) {
        visited[m][n] = true;
        if (m + 1 < board.length - 1 && board[m + 1][n] == 'O' && visited[m + 1][n] == false) {
            search(board, visited, m + 1, n);
        }
        
        if (m - 1 > 0 && board[m - 1][n] == 'O' && visited[m - 1][n] == false) {
            search(board, visited, m - 1, n);
        }
        
        if (n + 1 < board[0].length - 1 && board[m][n + 1] == 'O' && visited[m][n + 1] == false) {
            search(board, visited, m, n + 1);
        }
        
        if (n - 1 > 0 && board[m][n - 1] == 'O' && visited[m][n - 1] == false) {
            search(board, visited, m, n - 1);
        }
    }
}
