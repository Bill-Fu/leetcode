class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp;
        int low, high;
        
        if (nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            low = i + 1;
            high = nums.length - 1;
            while (low != high) {
                if (low != i + 1 && nums[low] == nums[low - 1]) {
                    low++;
                }
                else {
                    if (nums[low] + nums[high] == -(nums[i])) {
                        tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[low]);
                        tmp.add(nums[high]);
                        result.add(tmp);
                        low++;
                    }
                    else if (nums[low] + nums[high] < -(nums[i])) {
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        
        return result;
    }
}
