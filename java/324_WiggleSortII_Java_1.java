class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] extra = new int[nums.length];
        int i;
        
        for (i = 0; i < nums.length / 2; ++i) {
            extra[i * 2 + 1] = nums[nums.length - 1 - i];
        }

        for (; i < nums.length; ++i) {
            extra[(i - nums.length / 2) * 2] = nums[nums.length - 1 - i];
        }
        
        for (i = 0; i < nums.length; ++i) {
            nums[i] = extra[i];
        }
    }
}
