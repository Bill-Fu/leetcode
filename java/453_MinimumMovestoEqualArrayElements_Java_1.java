class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        
        for (int num : nums) {
            min = Math.min(num, min);
        }
        
        for (int num : nums) {
            result += num - min;
        }
        
        return result;
    }
}
