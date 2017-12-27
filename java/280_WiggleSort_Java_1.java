class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }
    
    public void swap(int[] nums, int fst, int snd) {
        int temp = nums[fst];
        
        nums[fst] = nums[snd];
        nums[snd] = temp;
    }
}
