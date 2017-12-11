class Solution {
    public int[] findErrorNums(int[] nums) {
        boolean[] table = new boolean[nums.length];
        int[] result = new int[2];
        int missing = (nums.length + 1) * nums.length / 2;
        
        for (int i = 0; i < nums.length; ++i) {
            if (table[nums[i] - 1]) {
                result[0] = nums[i];
            }
            else {
                table[nums[i] - 1] = true;
                missing -= nums[i];
            }
        }
        
        result[1] = missing;
        
        return result;
    }
}
