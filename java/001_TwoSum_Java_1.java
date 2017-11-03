class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<>();
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; ++i) {
            if (table.containsKey(target - nums[i]) == true) {
                if ((long) (target - nums[i]) + (long) (nums[i]) == (long) target) {
                    result[0] = table.get(target - nums[i]);
                    result[1] = i;
                    return result;
                }
            }
            table.put(nums[i], i);
        }
        
        return result;
    }
}
