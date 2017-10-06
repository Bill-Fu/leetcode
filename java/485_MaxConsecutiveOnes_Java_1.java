class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result, i, tmp;
        
        result = 0;
        tmp = 0;
        
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                if (tmp > result) {
                    result = tmp;
                }
                tmp = 0;
            }
            else {
                tmp++;
            }
        }
        
        if (tmp > result) {
            result = tmp;
        }
        
        return result;
    }
}
