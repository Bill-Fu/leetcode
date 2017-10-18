class Solution {
    public int maxProduct(int[] nums) {
        int max, min, result, temp;
        
        result = max = min = nums[0];
        
        for (int i = 1; i < nums.length; ++i) {
            temp = max;
            max = Math.max(Math.max(nums[i] * max, nums[i] * min), nums[i]);
            min = Math.min(Math.min(nums[i] * temp, nums[i] * min), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        
        return result;
    }
}
