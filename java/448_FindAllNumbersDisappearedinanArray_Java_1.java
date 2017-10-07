class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i, tmp;
        
        for (i = 0; i < nums.length; ++i) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
}
