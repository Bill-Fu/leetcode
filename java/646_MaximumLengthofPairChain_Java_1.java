class Solution {
    public int findLongestChain(int[][] pairs) {
        int result = 0;
        int[][] matrix = new int[pairs.length][pairs[0].length];
        
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
    
        result++;
        matrix[0][0] = pairs[0][0];
        matrix[0][1] = pairs[0][1];

        for (int i = 1; i < pairs.length; ++i) {
            for (int j = result - 1; j >= 0; --j) {
                if (pairs[i][0] > matrix[j][1] && (j == result - 1 || matrix[j + 1][1] > pairs[i][1])) {
                    matrix[j + 1][0] = matrix[j][0];
                    matrix[j + 1][1] = pairs[i][1];

                    if (j == result - 1) {
                        result++;
                    }
                }
            }

            if (pairs[i][1] < matrix[0][1]) {
                matrix[0][0] = pairs[i][0];
                matrix[0][1] = pairs[i][1];
            }
        }
        
        return result;
    }
}
