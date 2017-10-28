class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        permute(nums, new ArrayList<Integer>(), res);
        
        return res;
    }
    
    private void permute(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(cur);
        }
        else {
            for (int i = 0; i < nums.length; ++i) {
                if (cur.contains(nums[i]) == false) {
                    List<Integer> tmp = new ArrayList<>(cur);
                    tmp.add(nums[i]);
                    permute(nums, tmp, res);
                }
            }
        }
    }
}
