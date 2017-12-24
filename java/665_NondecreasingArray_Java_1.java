class Solution {
    public boolean checkPossibility(int[] nums) {
        if (check(nums)) {
            return true;
        }
        else {
            for (int i = 0; i < nums.length - 1; ++i) {
                if (nums[i] > nums[i + 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i + 1];
                    if (check(nums)) {
                        return true;
                    }
                    nums[i] = tmp;
                    nums[i + 1] = tmp;
                    return check(nums);
                }
            }
            
            return false;
        }
    }
    
    public boolean check(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
}
