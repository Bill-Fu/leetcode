class Solution {
    public int arrayPairSum(int[] nums) {
        int S = 0, i;
        
        Arrays.sort(nums);
        
        for(i = 0; i < nums.length / 2; ++i) {
            S += nums[2 * i];
        }
        
        return S;
    }
}
