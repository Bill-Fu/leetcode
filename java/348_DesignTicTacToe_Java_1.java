class TicTacToe {
    int[][] rows;
    int[][] cols;
    int[] diags1;
    int[] diags2;
    int size;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n][2];
        cols = new int[n][2];
        diags1 = new int[2];
        diags2 = new int[2];
        size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int result = 0;
        
        rows[row][player - 1]++;
        
        if (rows[row][player - 1] == size) {
            result = player;
        }
        
        cols[col][player - 1]++;
        
        if (cols[col][player - 1] == size) {
            result = player;
        }
        
        if (row == col) {
            diags1[player - 1]++;
        }
        
        if (diags1[player - 1] == size) {
            result = player;
        }
        
        if (row + col == size - 1) {
            diags2[player - 1]++;
        }
        
        if (diags2[player - 1] == size) {
            result = player;
        }
        
        return result;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
