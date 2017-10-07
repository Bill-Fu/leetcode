class Solution {
    public int majorityElement(int[] nums) {
        int result, time = 0, i;
        
        result = nums[0];
        
        for (i = 0; i < nums.length; ++i) {
            if (time == 0) {
                result = nums[i];
                time++;
            }
            else {
                if (nums[i] == result) {
                    time++;
                }
                else {
                    time--;
                }
            }
        }
        
        return result;
    }
}
