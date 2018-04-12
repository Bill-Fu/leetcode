class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] table = new int[nums.length][nums.length];
        
        for (int i = 0; i < nums.length; ++i) {
            table[i][i] = nums[i];
        }
        
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j + i < nums.length; ++j) {
                table[j][j + i] = Math.max(nums[j] - table[j + 1][j + i], nums[j + i] - table[j][j + i - 1]);
            }
        }
        
        return table[0][nums.length - 1] >= 0;
    }
}
