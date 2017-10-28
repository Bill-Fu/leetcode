class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        else {
            int x = matrix.length - 1, y = 0;
            while (matrix[x][y] != target) {
                if (matrix[x][y] < target) {
                    y++;
                    if (y == matrix[0].length) {
                        return false;
                    }
                }
                else {
                    x--;
                    if (x == -1) {
                        return false;
                    }
                }
            }
            
            return true;
        }
    }
}
