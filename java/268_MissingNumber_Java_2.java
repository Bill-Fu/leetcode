class Solution {
    public int missingNumber(int[] nums) {
        int nth_pos = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            while (nums[i] != i && nums[i] != nums.length) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }
            if (nums[i] != i) {
                nth_pos = i;
            }
        }
        
        return nth_pos;
    }
}
