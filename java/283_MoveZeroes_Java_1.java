class Solution {
    public void moveZeroes(int[] nums) {
        int pointer_0, pointer_1;
        
        pointer_0 = 0;
        pointer_1 = 0;
        
        while (pointer_0 < nums.length && nums[pointer_0] != 0) {
            pointer_0++;
        }
        
        pointer_1=pointer_0;
        
        while (pointer_1 < nums.length) {
            while (pointer_1 < nums.length && nums[pointer_1] == 0) {
                pointer_1++;
            }
            if (pointer_1 < nums.length) {
                nums[pointer_0] = nums[pointer_1];
                nums[pointer_1] = 0;
                pointer_0++;
                pointer_1++;
            }
        }
    }
}
