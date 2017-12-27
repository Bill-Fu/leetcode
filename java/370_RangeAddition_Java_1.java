class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        
        for (int i = 0; i < updates.length; ++i) {
            for (int j = updates[i][0]; j <= updates[i][1]; ++j) {
                result[j] += updates[i][2];
            }
        }
        
        return result;
    }
}
