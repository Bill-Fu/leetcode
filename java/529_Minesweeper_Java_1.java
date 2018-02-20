class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        else {
            boolean[][] visited = new boolean[board.length][board[0].length];
            
            update(board, click[0], click[1], visited);
            
            return board;
        }
    }
    
    public void update(char[][] board, int clickX, int clickY, boolean visited[][]) {
        if (board[clickX][clickY] == 'E' && visited[clickX][clickY] == false) {
            int cnt = 0;
            
            for (int i = -1; i < 2; ++i) {
                for (int j = -1; j < 2; ++j) {
                    if (clickX + i >= 0 && clickX + i < board.length && clickY + j >= 0 && clickY + j < board[0].length && board[clickX + i][clickY + j] == 'M') {
                        cnt++;
                    }
                }
            }
            
            visited[clickX][clickY] = true;
            
            if (cnt == 0) {
                board[clickX][clickY] = 'B';
                for (int i = -1; i < 2; ++i) {
                    for (int j = -1; j < 2; ++j) {
                        if (clickX + i >= 0 && clickX + i < board.length && clickY + j >= 0 && clickY + j < board[0].length) {
                            update(board, clickX + i, clickY + j, visited);   
                        }
                    }
                }
            }
            else {
                board[clickX][clickY] = (char)('0' + cnt);
            }
        }
    }
}
