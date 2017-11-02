class Solution {
    public int missingNumber(int[] nums) {
        boolean[] table = new boolean [nums.length + 1];
        
        for (int i = 0; i < nums.length; ++i) {
            table[nums[i]] = true;
        }
        
        for (int i = 0; i < table.length; ++i) {
            if (table[i] == false) {
                return i;
            }
        }
        
        return -1;
    }
}
