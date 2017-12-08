class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        else {
            int sum = 0;
            
            for (int i = 0; i < nums.length; ++i) {
                sum += nums[i];
            }
            
            int cur = 0;
            
            for (int i = 0; i < nums.length; ++i) {
                if (cur * 2 + nums[i] == sum) {
                    return i;
                }
                else {
                    cur += nums[i];
                }
            }
            
            return -1;
        }
    }
}
