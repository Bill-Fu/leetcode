class Solution {
    public int findDuplicate(int[] nums) {
        int slow, fast;
        slow = fast = nums.length - 1;
        
        do {
            slow = nums[slow] - 1;
            fast = nums[nums[fast] - 1] - 1;
        } while (slow != fast);
        
        slow = nums.length - 1;
        
        do {
            slow = nums[slow] - 1;
            fast = nums[fast] - 1;
        } while (slow != fast);
        
        return slow + 1;
    }
}
