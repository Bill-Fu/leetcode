class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] table = new int[9];
        
        for (int i = 0; i < 9; ++i) {
            Arrays.fill(table, 0);
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    if (table[board[i][j] - '0' - 1] != 0) {
                        return false;
                    }
                    else {
                        table[board[i][j] - '0' - 1] = 1;
                    }
                }
            }
        }
        
        for (int j = 0; j < 9; ++j) {
            Arrays.fill(table, 0);
            for (int i = 0; i < 9; ++i) {
                if (board[i][j] != '.') {
                    if (table[board[i][j] - '0' - 1] != 0) {
                        return false;
                    }
                    else {
                        table[board[i][j] - '0' - 1] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                Arrays.fill(table, 0);
                for (int p = 0; p < 3; ++p) {
                    for (int q = 0; q < 3; ++q) {
                        if (board[i * 3 + p][j * 3 + q] != '.') {
                            if (table[board[i * 3 + p][j * 3 + q] - '0' - 1] != 0) {
                                return false;
                            }
                            else {
                                table[board[i * 3 + p][j * 3 + q] - '0' - 1] = 1;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
