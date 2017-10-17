class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        boolean[][] table = new boolean[matrix.length][matrix[0].length];
        int size = matrix.length * matrix[0].length;
        int dir = 0;
        int mMax, nMax;
        int m = 0, n = -1;
        
        mMax = matrix.length - 1;
        nMax = matrix[0].length - 1;
        
        while (result.size() != size) {
            switch(dir) {
                case 0:
                    if (n + 1 > nMax || table[m][n + 1] == true) {
                        dir++;
                    }
                    else {
                        n++;
                        result.add(matrix[m][n]);
                        table[m][n] = true;
                    }
                    break;
                case 1:
                    if (m + 1 > mMax || table[m + 1][n] == true) {
                        dir++;
                    }
                    else {
                        m++;
                        result.add(matrix[m][n]);
                        table[m][n] = true;
                    }
                    break;
                case 2:
                    if (n - 1 < 0 || table[m][n - 1] == true) {
                        dir++;
                    }
                    else {
                        n--;
                        result.add(matrix[m][n]);
                        table[m][n] = true;
                    }
                    break;
                case 3:
                    if (m - 1 < 0 || table[m - 1][n] == true) {
                        dir = 0;
                    }
                    else {
                        m--;
                        result.add(matrix[m][n]);
                        table[m][n] = true;
                    }
                    break;
            }
        }
        
        return result;
    }
}
