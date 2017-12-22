class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> setNum = new HashSet<>();
        Set<Integer> setPair = new HashSet<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; ++i) {
            if (setPair.contains(nums[i]) == false) {
                if (setNum.contains(nums[i] - k)) {
                    setPair.add(nums[i]);
                }
            }
            setNum.add(nums[i]);
        }
        
        return setPair.size();
    }
}
