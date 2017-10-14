// Use extra space
class Solution {
    public void gameOfLife(int[][] board) {
        int result[][] = new int[board.length][board[0].length];
        int countLive = 0;
        
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[0].length; ++j) {
                countLive = 0;
                for (int k = -1; k < 2; ++k) {
                    for (int n = -1; n < 2; ++n) {
                        if (k == 0 && n ==0) {
                            continue;
                        }
                        else {
                            if (i + k >= 0 && i + k < board.length && j + n >= 0 && j + n < board[0].length) {
                                if (board[i + k][j + n] == 1) {
                                countLive++;
                                }
                            }
                        }
                    }
                }
                
                if (board[i][j] == 1) {
                    switch(countLive) {
                        case 0:
                        case 1: 
                            result[i][j] = 0;
                            break;
                        case 2:
                        case 3:
                            result[i][j] = 1;
                            break;
                        default:
                            result[i][j] = 0;
                            break;
                    }
                }
                else {
                    if (countLive == 3) {
                        result[i][j] = 1;
                    }
                    else {
                        result[i][j] = 0;
                    }
                }
            }
        }
        
        for (int i = 0; i < result.length; ++i) {
            for (int j = 0; j < result[0].length; ++j) {
                board[i][j] = result[i][j];
            }
        }
    }
}
