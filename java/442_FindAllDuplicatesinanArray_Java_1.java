class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i, tmp;
        
        for (i = 0; i < nums.length; ++i) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
            {
                tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        
        return result;
    }
}
