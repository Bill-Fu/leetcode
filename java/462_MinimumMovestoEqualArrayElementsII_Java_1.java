class Solution {
    public int minMoves2(int[] nums) {
        int result = 0;
        int select = nums.length / 2;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; ++i) {
            result += Math.abs(nums[i] - nums[select]);
        }
        
        return result;
    }
}
