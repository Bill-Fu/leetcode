class Solution {
    public int thirdMax(int[] nums) {
        long num1 = Long.MIN_VALUE;
        long num2 = Long.MIN_VALUE;
        long num3 = Long.MIN_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > num1) {
                num3 = num2;
                num2 = num1;
                num1 = nums[i];
            }
            else if (num1 > nums[i] && nums[i] > num2) {
                num3 = num2;
                num2 = nums[i];
            }
            else if (num2 > nums[i] && nums[i] > num3) {
                num3 = nums[i];
            }
        }
        
        return num3 == Long.MIN_VALUE? (int) num1: (int) num3;
    }
}
