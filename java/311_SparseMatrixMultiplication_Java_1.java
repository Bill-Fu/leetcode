class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        List<HashSet<Integer>> matA = new ArrayList<>();
        
        for (int i = 0; i < A.length; ++i) {
            matA.add(new HashSet<Integer>());
            
            for (int j = 0; j < A[i].length; ++j) {
                if (A[i][j] != 0) {
                    matA.get(i).add(j);
                }
            }
        }
        
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B[0].length; ++j) {
                for (int idx: matA.get(i)) {
                    result[i][j] += A[i][idx] * B[idx][j];
                }
            }
        }
        
        return result;
    }
}
