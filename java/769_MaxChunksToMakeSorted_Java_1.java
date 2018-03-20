class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        boolean[] table = new boolean[arr.length];
        
        for (int i = 0; i < arr.length; ++i) {
            table[arr[i]] = true;
            
            for (int j = 0; j <= i; ++j) {
                if (table[j] == false) {
                    result--;
                    break;
                }
            }
            
            result++;
        }
        
        return result;
    }
}
