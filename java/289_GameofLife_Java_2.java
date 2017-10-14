// In-place, no extra space need
class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                int count = 0;
                for (int p = -1; p < 2; ++p) {
                    for (int q = -1; q < 2; ++q) {
                        if (p != 0 || q != 0) {
                            if (i + p >= 0 && i + p < board.length && j + q >= 0 && j + q < board[0].length) {
                                if (board[i + p][j + q] % 2 == 1) {
                                    count++;
                                }
                            }
                        }
                    }
                }
                if (board[i][j] == 1) {
                    switch (count) {
                        case 2:
                        case 3:
                            board[i][j] = 1;
                            break;
                        default:
                            board[i][j] = 3;
                    }
                }
                else {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
                else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }
}
