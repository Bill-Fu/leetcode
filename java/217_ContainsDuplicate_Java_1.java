class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> eles = new HashSet<Integer>();
        int i;
        
        for (i = 0; i < nums.length; ++i) {
            if (eles.add(nums[i]) == false){
                return true;
            }
        }
        
        return false;
    }
}
