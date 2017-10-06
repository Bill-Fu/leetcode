class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length == r * c) {
            int result[][] = new int[r][c];
            int i, j, k = 0;
            
            for (i = 0; i < nums.length; i++) {
                for (j = 0; j < nums[0].length; j++) {
                    result[k/c][k%c] = nums[i][j];
                    k++;
                }
            }
            
            return result;
        } else {
            return nums;
        }
    }
}
