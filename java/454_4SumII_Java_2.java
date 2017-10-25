class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int result = 0;
        int tmp;
        
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                tmp = A[i] + B[j];
                if (map1.containsKey(tmp)) {
                    map1.put(tmp, map1.get(tmp) + 1);
                }
                else {
                    map1.put(tmp, 1);
                }
            }
        }
        
        for (int i = 0; i < C.length; ++i) {
            for (int j = 0; j < D.length; ++j) {
                tmp = C[i] + D[j];
                if (map1.containsKey(-tmp)) {
                    result += map1.get(-tmp);
                }
            }
        }
        
        return result;
    }
}
