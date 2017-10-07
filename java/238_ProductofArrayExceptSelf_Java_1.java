class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        int i, tmp;
        
        tmp = 1;
        
        for (i = 0; i < nums.length; ++i) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        
        tmp = 1;
        
        for (i = nums.length - 1; i >= 0; --i) {
            result[i] *= tmp;
            tmp *= nums[i];
        }
        
        return result;
    }
}
