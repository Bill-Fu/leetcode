class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp;
        
        if (nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int num: nums) {
            if (table.containsKey(num) == true) {
                table.put(num, table.get(num) + 1);
            }
            else {
                table.put(num, 1);
            }
        }
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            table.put(nums[i], table.get(nums[i]) - 1);
            
            for (int j = i + 1; j < nums.length - 1; ++j) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                table.put(nums[j], table.get(nums[j]) - 1);
                
                if (table.get(-(nums[i] + nums[j])) != null && table.get(-(nums[i] + nums[j])) > 0) {
                    if (-(nums[i] + nums[j]) >= nums[j]) {
                        tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(-(nums[i] + nums[j]));
                        result.add(tmp);
                    }
                }
                
                table.put(nums[j], table.get(nums[j]) + 1);
            }
            table.put(nums[i], table.get(nums[i]) + 1);
        }
        
        return result;
    }
}
