class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            int[] result = new int[matrix.length * matrix[0].length];
            int pos = 0;

            for (int i = 0; i < matrix.length + matrix[0].length - 1; ++i) {
                if (i % 2 == 0) {
                    for (int j = i; j >= 0; --j) {
                        if (j >= 0 && j < matrix.length && (i - j) >= 0 && (i - j) < matrix[0].length) {
                            result[pos++] = matrix[j][i - j];   
                        }
                    }
                }
                else {
                    for (int j = 0; j <= i; ++j) {
                        if (j >= 0 && j < matrix.length && (i - j) >= 0 && (i - j) < matrix[0].length) {
                            result[pos++] = matrix[j][i - j];   
                        }
                    }
                }
            }

            return result;            
        }
        else {
            return new int[0];
        }
    }
}
