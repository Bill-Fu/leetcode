class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[A.length];
        
        for (int i = 0; i < B.length; ++i) {
            map.put(B[i], i);
        }
        
        for (int i = 0; i < A.length; ++i) {
            result[i] = map.get(A[i]);
        }
        
        return result;
    }
}
